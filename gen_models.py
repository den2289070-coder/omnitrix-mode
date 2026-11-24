#!/usr/bin/env python3
"""Генератор моделей и текстур пришельцев: пишет AlienModelData.java и PNG-текстуры."""
import random, zlib, struct, os
ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..')
JAVA = os.path.join(ROOT, 'src/main/java/com/omnitrix/mod/client/AlienModelData.java')
TEX = os.path.join(ROOT, 'src/main/resources/assets/omnitrix/textures/entity')

def Cb(o, s, c, d=()): return dict(o=o, s=s, c=c, d=list(d))
def P(piv, cubes, rot=(0, 0, 0)): return dict(piv=piv, cubes=cubes, rot=rot)
def omni(w): return [('front', w // 2 - 2, 3, 4, 4, (25, 25, 25)), ('front', w // 2 - 1, 4, 2, 2, (80, 255, 0))]
def eyes(col, y=3, sz=2, w=8, gap=None):
    gap = gap if gap is not None else w - 2 - 2 * sz
    return [('front', 1 + 0, y, sz, sz, col), ('front', w - 1 - sz, y, sz, sz, col)]

def arm(side, col, w=4, h=12, d=4, px=5, py=2, pz=0, hand=None, deco=(), extra=(), name=None):
    r = side == 'r'
    ox = -(w - 1) if r else -1
    cubes = [Cb((ox, -2, -d / 2), (w, h, d), col, deco)]
    if hand:
        hc, hh = hand
        cubes.append(Cb((ox - 0.5, -2 + h - hh, -d / 2 - 0.5), (w + 1, hh, d + 1), hc))
    for o, sz, c in extra:
        cubes.append(Cb((o[0] if r else -(o[0] + sz[0]), o[1], o[2]), sz, c))
    return (name or ('right_arm' if r else 'left_arm')), P(((-1 if r else 1) * px, py, pz), cubes)

def leg(side, col, w=4, h=12, d=4, px=1.9, py=12, deco=(), extra=(), name=None):
    r = side == 'r'
    cubes = [Cb((-w / 2, 0, -d / 2), (w, h, d), col, deco)]
    for o, sz, c in extra:
        cubes.append(Cb((o[0] if r else -(o[0] + sz[0]), o[1], o[2]), sz, c))
    return (name or ('right_leg' if r else 'left_leg')), P(((-1 if r else 1) * px, py, 0), cubes)

def build(head, body, arms, legs, extras=()):
    parts = {'head': head, 'body': body}
    for n, p in list(arms) + list(legs) + list(extras): parts[n] = p
    return parts

A = {}
# ---------------- 1. HEATBLAST ----------------
rock = (48, 40, 42); lava = (255, 110, 20); f1 = (255, 150, 30); f2 = (255, 205, 60); f3 = (255, 245, 140); wh = (255, 255, 225)
A['heatblast'] = build(
    P((0, 0, 0), [Cb((-4, -8, -4), (8, 8, 8), rock, eyes(wh) + [('front', 2, 6, 4, 1, lava)]),
                  Cb((-3, -13, -3), (6, 5, 6), f1), Cb((-2, -17, -2), (4, 4, 4), f2), Cb((-1, -20, -1), (2, 3, 2), f3),
                  Cb((-6, -10, -1), (2, 4, 2), f1), Cb((4, -10, -1), (2, 4, 2), f1)]),
    P((0, 0, 0), [Cb((-4, 0, -2), (8, 12, 4), rock, [('front', 0, 1, 1, 6, lava), ('front', 7, 5, 1, 6, lava), ('front', 3, 9, 2, 3, lava)] + omni(8))]),
    [arm('r', rock, hand=(lava, 4), deco=[('front', 1, 3, 2, 1, lava)]), arm('l', rock, hand=(lava, 4), deco=[('front', 1, 3, 2, 1, lava)])],
    [leg('r', rock, extra=[((-2.5, 9, -2.5), (5, 3, 5), lava)]), leg('l', rock, extra=[((-2.5, 9, -2.5), (5, 3, 5), lava)])])
# ---------------- 2. WILDMUTT ----------------
fur = (205, 85, 40); fur2 = (150, 55, 30); mane = (110, 38, 25); belly = (232, 160, 100)
A['wildmutt'] = build(
    P((0, 0, -5), [Cb((-4, -7, -4), (8, 7, 7), fur), Cb((-2, -3, -8), (4, 3, 4), fur2, [('front', 0, 2, 4, 1, wh), ('front', 1, 0, 2, 1, (15, 15, 15))]),
                   Cb((-5, -10, 0), (3, 3, 2), fur2), Cb((2, -10, 0), (3, 3, 2), fur2), Cb((-5, -8, 2), (10, 9, 5), mane)]),
    P((0, 0, 0), [Cb((-5, 0, -3), (10, 12, 6), fur, [('front', 2, 1, 6, 10, belly)] + omni(10)), Cb((-1, -2, 3), (2, 3, 3), mane), Cb((-1, 4, 3), (2, 3, 3), mane)], rot=(0.5, 0, 0)),
    [arm('r', fur, w=5, h=15, d=5, px=6, py=3, pz=-3, hand=(fur2, 4)), arm('l', fur, w=5, h=15, d=5, px=6, py=3, pz=-3, hand=(fur2, 4))],
    [leg('r', fur, w=5, h=12, d=5, px=2.4, extra=[((-3, 9, -3.5), (6, 3, 6), fur2)]), leg('l', fur, w=5, h=12, d=5, px=2.4, extra=[((-3, 9, -3.5), (6, 3, 6), fur2)])])
# ---------------- 3. DIAMONDHEAD ----------------
cr = (110, 225, 205); cr2 = (70, 170, 170); cr3 = (195, 255, 245); dg = (20, 90, 60)
A['diamondhead'] = build(
    P((0, 0, 0), [Cb((-4, -8, -4), (8, 8, 8), cr, eyes(dg, 3, 2) + [('front', 3, 6, 2, 1, cr2)]), Cb((-1, -13, -1), (2, 5, 2), cr3),
                  Cb((-5, -11, -1), (2, 5, 2), cr2), Cb((3, -11, -1), (2, 5, 2), cr2), Cb((-1, -11, 2), (2, 4, 2), cr2)]),
    P((0, 0, 0), [Cb((-4, 0, -2), (8, 12, 4), cr, [('front', 1, 1, 2, 4, cr3), ('front', 5, 6, 2, 4, cr2), ('front', 0, 9, 8, 3, cr2)] + omni(8))]),
    [arm('r', cr, hand=(cr3, 4), extra=[((-4, -5, -1), (2, 5, 2), cr3)]), arm('l', cr, hand=(cr3, 4), extra=[((-4, -5, -1), (2, 5, 2), cr3)])],
    [leg('r', cr, extra=[((-2.5, 9, -3), (5, 3, 5), cr2)]), leg('l', cr, extra=[((-2.5, 9, -3), (5, 3, 5), cr2)])])
# ---------------- 4. XLR8 ----------------
dk = (25, 30, 58); bl = (60, 170, 255); vis = (10, 10, 20)
A['xlr8'] = build(
    P((0, 0, 0), [Cb((-4, -8, -4), (8, 8, 8), dk, [('front', 0, 2, 8, 4, vis), ('front', 1, 3, 2, 2, (170, 240, 255)), ('front', 5, 3, 2, 2, (170, 240, 255))]),
                  Cb((-3, -7, 4), (6, 5, 10), dk, [('top', 2, 0, 2, 10, bl)]), Cb((-1, -9, 3), (2, 1, 9), bl)]),
    P((0, 0, 0), [Cb((-3, 0, -2), (6, 12, 4), dk, [('front', 0, 0, 1, 12, bl), ('front', 5, 0, 1, 12, bl)] + omni(6))]),
    [arm('r', dk, w=3, h=12, d=3, px=4.5, hand=(bl, 3)), arm('l', dk, w=3, h=12, d=3, px=4.5, hand=(bl, 3))],
    [leg('r', dk, w=3, h=12, d=3, px=1.8, extra=[((-2, 10, -4), (3, 2, 7), bl)]), leg('l', dk, w=3, h=12, d=3, px=1.8, extra=[((-2, 10, -4), (3, 2, 7), bl)])],
    [('tail', P((0, 9, 2), [Cb((-1, 0, 0), (2, 2, 11), dk, [('top', 0, 0, 2, 11, bl)])]))])
# ---------------- 5. GREY MATTER ----------------
sk = (135, 152, 162); sk2 = (95, 110, 122); ge = (70, 230, 70); bk = (15, 15, 18)
A['grey_matter'] = build(
    P((0, 1, 0), [Cb((-6, -10, -5), (12, 10, 10), sk, [('front', 1, 3, 4, 5, ge), ('front', 7, 3, 4, 5, ge), ('front', 2, 3, 2, 5, bk), ('front', 8, 3, 2, 5, bk), ('front', 5, 8, 2, 1, bk)])]),
    P((0, 0, 0), [Cb((-3, 0, -2), (6, 9, 4), sk, [('front', 0, 5, 6, 4, bk)] + omni(6)[:0] + [('front', 1, 1, 4, 3, (25, 25, 25)), ('front', 2, 2, 2, 1, (80, 255, 0))])]),
    [arm('r', sk, w=2, h=9, d=2, px=3.5, py=1, hand=(sk2, 3)), arm('l', sk, w=2, h=9, d=2, px=3.5, py=1, hand=(sk2, 3))],
    [leg('r', sk, w=2, h=10, d=2, px=1.5, py=9, extra=[((-2, 9, -3), (4, 1, 4), sk2)]), leg('l', sk, w=2, h=10, d=2, px=1.5, py=9, extra=[((-2, 9, -3), (4, 1, 4), sk2)])])
# ---------------- 6. FOUR ARMS ----------------
rd = (185, 45, 38); rd2 = (140, 30, 28); pants = (55, 45, 60); cream = (235, 225, 200)
fa_arm = lambda s, pz, py, name: arm(s, rd, w=5, h=13, d=4, px=6.5, py=py, pz=pz, hand=(rd2, 4), name=name)
A['four_arms'] = build(
    P((0, -1, 0), [Cb((-3, -8, -3), (6, 7, 6), rd, [('front', 0, 2, 1, 1, wh), ('front', 5, 2, 1, 1, wh), ('front', 1, 3, 1, 1, wh), ('front', 4, 3, 1, 1, wh), ('front', 1, 5, 4, 1, bk)]),
                   Cb((-4, -10, -2), (2, 3, 2), cream), Cb((2, -10, -2), (2, 3, 2), cream)]),
    P((0, 0, 0), [Cb((-6, 0, -3), (12, 13, 6), rd, [('front', 1, 1, 4, 4, rd2), ('front', 7, 1, 4, 4, rd2), ('front', 0, 10, 12, 3, bk)] + omni(12))]),
    [fa_arm('r', -1, 1, 'right_arm'), fa_arm('l', -1, 1, 'left_arm'), fa_arm('r', 1.5, 6, 'right_arm2'), fa_arm('l', 1.5, 6, 'left_arm2')],
    [leg('r', rd, w=5, h=11, d=5, px=2.5, py=13, extra=[((-3.5, 0, -3.5), (6, 6, 6), pants), ((-3, 9, -3.5), (6, 2, 6), bk)]),
     leg('l', rd, w=5, h=11, d=5, px=2.5, py=13, extra=[((-3.5, 0, -3.5), (6, 6, 6), pants), ((-3, 9, -3.5), (6, 2, 6), bk)])])
# ---------------- 7. STINKFLY ----------------
gr = (100, 145, 55); gr2 = (70, 110, 40); bel = (195, 205, 115); ey = (200, 45, 40); wg = (200, 235, 210); wv = (120, 170, 140)
wing = lambda: Cb((-14, 0, 0), (14, 1, 6), wg, [('top', 0, 1, 14, 1, wv), ('top', 0, 4, 14, 1, wv)])
A['stinkfly'] = build(
    P((0, 0, 0), [Cb((-3, -7, -3), (6, 7, 6), gr, [('front', 1, 5, 4, 1, gr2)]), Cb((-6, -7, -4), (3, 5, 5), ey, [('front', 0, 1, 3, 2, (255, 120, 80))]), Cb((3, -7, -4), (3, 5, 5), ey, [('front', 0, 1, 3, 2, (255, 120, 80))]),
                  Cb((-2, -11, -1), (1, 4, 1), gr2), Cb((1, -11, -1), (1, 4, 1), gr2), Cb((-1, -3, -6), (2, 3, 3), gr2), Cb((-2, -2, -5), (1, 2, 2), gr2), Cb((1, -2, -5), (1, 2, 2), gr2)]),
    P((0, 0, 0), [Cb((-3, 0, -2), (6, 12, 4), gr, [('front', 1, 0, 4, 12, bel), ('front', 1, 3, 4, 1, gr2), ('front', 1, 6, 4, 1, gr2)] + [('front', 1, 8, 4, 3, (25, 25, 25)), ('front', 2, 9, 2, 1, (80, 255, 0))])]),
    [arm('r', gr, w=2, h=12, d=2, px=4, hand=(gr2, 3)), arm('l', gr, w=2, h=12, d=2, px=4, hand=(gr2, 3))],
    [leg('r', gr2, w=2, h=12, d=2, px=1.5), leg('l', gr2, w=2, h=12, d=2, px=1.5)],
    [('right_wing', P((-2, 1, 2), [wing()])), ('left_wing', P((2, 1, 2), [Cb((0, 0, 0), (14, 1, 6), wg, [('top', 0, 1, 14, 1, wv), ('top', 0, 4, 14, 1, wv)])]))])
# ---------------- 8. RIPJAWS ----------------
bu = (55, 105, 135); bu2 = (35, 70, 100); bby = (215, 215, 190); fin = (28, 58, 90); gold = (255, 200, 40)
A['ripjaws'] = build(
    P((0, 0, 0), [Cb((-4, -7, -4), (8, 7, 8), bu, [('front', 1, 2, 2, 2, gold), ('front', 5, 2, 2, 2, gold)]), Cb((-4, -1, -6), (8, 3, 4), bu2, [('front', 0, 0, 8, 1, wh), ('front', 1, 1, 1, 1, wh), ('front', 3, 1, 1, 1, wh), ('front', 6, 1, 1, 1, wh)]),
                  Cb((-1, -12, -3), (2, 5, 8), fin), Cb((-6, -6, -1), (2, 3, 3), fin), Cb((4, -6, -1), (2, 3, 3), fin)]),
    P((0, 0, 0), [Cb((-5, 0, -2), (10, 12, 4), bu, [('front', 2, 1, 6, 11, bby)] + omni(10)), Cb((-1, 1, 2), (2, 9, 4), fin)]),
    [arm('r', bu, px=6, hand=(bu2, 4), extra=[((-4, 3, -1), (1, 6, 3), fin)]), arm('l', bu, px=6, hand=(bu2, 4), extra=[((-4, 3, -1), (1, 6, 3), fin)])],
    [leg('r', bu, px=2.5, extra=[((-3, 10, -5), (6, 2, 3), fin)]), leg('l', bu, px=2.5, extra=[((-3, 10, -5), (6, 2, 3), fin)])],
    [('tail', P((0, 10, 2), [Cb((-1, -4, 0), (2, 8, 7), fin)]))])
# ---------------- 9. UPGRADE ----------------
bkk = (18, 18, 22); bk2 = (32, 34, 42); gn = (60, 255, 90); dgn = (20, 120, 50)
circ = lambda: [('front', 0, 2, 4, 1, dgn), ('front', 3, 2, 1, 6, dgn), ('front', 0, 8, 4, 1, dgn), ('right', 1, 4, 2, 1, dgn)]
A['upgrade'] = build(
    P((0, 0, 0), [Cb((-4, -8, -4), (8, 8, 8), bkk, [('front', 1, 2, 6, 3, gn), ('front', 3, 3, 2, 1, (220, 255, 225)), ('left', 1, 1, 6, 1, dgn), ('right', 1, 1, 6, 1, dgn), ('left', 1, 5, 4, 1, dgn), ('right', 3, 5, 4, 1, dgn)])]),
    P((0, 0, 0), [Cb((-4, 0, -2), (8, 12, 4), bkk, [('front', 0, 1, 2, 1, dgn), ('front', 6, 1, 2, 1, dgn), ('front', 1, 8, 6, 1, dgn), ('front', 3, 9, 1, 3, dgn), ('front', 4, 4, 1, 4, dgn)] + omni(8))]),
    [arm('r', bkk, deco=circ(), hand=(bk2, 4), extra=[((-4, -3, -3), (5, 3, 5), bk2)]), arm('l', bkk, deco=circ(), hand=(bk2, 4), extra=[((-4, -3, -3), (5, 3, 5), bk2)])],
    [leg('r', bkk, deco=[('front', 1, 2, 1, 8, dgn)], extra=[((-2.5, 9, -2.5), (5, 3, 5), bk2)]), leg('l', bkk, deco=[('front', 2, 2, 1, 8, dgn)], extra=[((-2.5, 9, -2.5), (5, 3, 5), bk2)])])
# ---------------- 10. GHOSTFREAK ----------------
pw = (215, 220, 228); pg = (150, 155, 170); pp = (70, 25, 92); pr = (200, 30, 60)
A['ghostfreak'] = build(
    P((0, 0, 0), [Cb((-4, -8, -4), (8, 8, 8), pw, [('front', 1, 2, 6, 4, bk), ('front', 3, 3, 2, 2, pr), ('front', 1, 6, 6, 1, pp), ('front', 2, 7, 1, 1, bk), ('front', 4, 7, 1, 1, bk), ('front', 6, 7, 1, 1, bk)])]),
    P((0, 0, 0), [Cb((-4, 0, -2), (8, 12, 4), pw, [('front', 0, 2, 8, 1, pp), ('front', 0, 5, 8, 1, pp), ('front', 0, 8, 8, 1, pp)] + omni(8)), Cb((-5, -1, 2), (10, 17, 1), pp)]),
    [arm('r', pw, w=3, h=12, d=3, px=4.5, hand=(pp, 4)), arm('l', pw, w=3, h=12, d=3, px=4.5, hand=(pp, 4))],
    [leg('r', pp, w=4, h=6, d=4, px=2, extra=[((-1, 6, -1), (2, 6, 2), pg)]), leg('l', pp, w=4, h=6, d=4, px=2, extra=[((-1, 6, -1), (2, 6, 2), pg)])],
    [('tail', P((0, 12, 2), [Cb((-3, 0, 0), (2, 12, 2), pp), Cb((1, 0, 0), (2, 12, 2), pp), Cb((-1, 0, 1), (2, 14, 2), pg)]))])

ORDER = ['heatblast', 'wildmutt', 'diamondhead', 'xlr8', 'grey_matter', 'four_arms', 'stinkfly', 'ripjaws', 'upgrade', 'ghostfreak']

# ---------------- texture + java ----------------
def pack(cubes, size):
    x = y = sh = 0
    for c in cubes:
        w, h, d = c['s']; W = 2 * (d + w); H = d + h
        if x + W > size: x = 0; y += sh; sh = 0
        c['uv'] = (x, y); x += W; sh = max(sh, H)
    return y + sh <= size

def png(path, size, img):
    raw = b''.join(b'\x00' + b''.join(bytes(px) for px in row) for row in img)
    ch = lambda t, d: struct.pack('>I', len(d)) + t + d + struct.pack('>I', zlib.crc32(t + d) & 0xffffffff)
    open(path, 'wb').write(b'\x89PNG\r\n\x1a\n' + ch(b'IHDR', struct.pack('>IIBBBBB', size, size, 8, 6, 0, 0, 0)) + ch(b'IDAT', zlib.compress(raw)) + ch(b'IEND', b''))

def paint(cubes, size, seed):
    rng = random.Random(seed)
    img = [[(0, 0, 0, 0)] * size for _ in range(size)]
    def fill(x0, y0, w, h, col, border=True):
        for yy in range(y0, y0 + h):
            for xx in range(x0, x0 + w):
                n = rng.randint(-7, 7)
                k = 0.82 if border and (xx in (x0, x0 + w - 1) or yy in (y0, y0 + h - 1)) and w > 2 and h > 2 else 1.0
                img[yy][xx] = tuple(max(0, min(255, int((c + n) * k))) for c in col) + (255,)
    for c in cubes:
        u, v = c['uv']; w, h, d = c['s']
        faces = {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h),
                 'front': (u + d, v + d, w, h), 'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}
        for f in faces.values(): fill(*f, c['c'])
        for face, x, y, dw, dh, col in c['d']:
            fx, fy, fw, fh = faces[face]
            for yy in range(y, min(y + dh, fh)):
                for xx in range(x, min(x + dw, fw)):
                    if xx >= 0 and yy >= 0: img[fy + yy][fx + xx] = tuple(col) + (255,)
    return img

f = lambda x: f"{float(x)}F"
java = ['// АВТОГЕНЕРАЦИЯ: tools/gen_models.py — не править руками',
        'package com.omnitrix.mod.client;', '',
        'import net.minecraft.client.model.geom.builders.*;', '', 'public class AlienModelData {']
feet = []
os.makedirs(TEX, exist_ok=True)
for idx, key in enumerate(ORDER):
    parts = A[key]
    cubes = [c for p in parts.values() for c in p['cubes']]
    for size in (128, 256, 512):
        if pack(cubes, size): break
    png(os.path.join(TEX, key + '.png'), size, paint(cubes, size, idx + 1))
    fy = 24.0
    ys = [p['piv'][1] + c['o'][1] + c['s'][1] for n, p in parts.items() if n.endswith('_leg') for c in p['cubes']]
    if ys: fy = max(ys)
    feet.append(fy)
    java.append(f'    public static LayerDefinition {key}() {{')
    java.append('        MeshDefinition m = new MeshDefinition();')
    java.append('        PartDefinition r = m.getRoot();')
    for n, p in parts.items():
        b = 'CubeListBuilder.create()' + ''.join(
            f'.texOffs({c["uv"][0]}, {c["uv"][1]}).addBox({f(c["o"][0])}, {f(c["o"][1])}, {f(c["o"][2])}, {f(c["s"][0])}, {f(c["s"][1])}, {f(c["s"][2])})' for c in p['cubes'])
        pv, rt = p['piv'], p['rot']
        java.append(f'        r.addOrReplaceChild("{n}", {b}, PartPose.offsetAndRotation({f(pv[0])}, {f(pv[1])}, {f(pv[2])}, {f(rt[0])}, {f(rt[1])}, {f(rt[2])}));')
    java.append(f'        return LayerDefinition.create(m, {size}, {size});')
    java.append('    }')
    java.append('')
java.append('    public static final float[] FEET = {' + ', '.join(f(x) for x in feet) + '};')
java.append('')
java.append('    public static LayerDefinition create(int i) {')
java.append('        return switch (i) {')
for idx, key in enumerate(ORDER): java.append(f'            case {idx} -> {key}();')
java.append('            default -> heatblast();')
java.append('        };')
java.append('    }')
java.append('}')
os.makedirs(os.path.dirname(JAVA), exist_ok=True)
open(JAVA, 'w').write('\n'.join(java) + '\n')
print('OK', feet)
