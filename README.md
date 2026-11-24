# Omnitrix (Ben 10) — Forge 1.20.1 (47.3.0)

Библиотеки Minecraft-а не нужны (GeckoLib не используется), только Forge 1.20.1.

## Как получить файл мода (.jar)
Вариант A — без установки чего-либо: загрузите эту папку в новый репозиторий на GitHub,
вкладка Actions -> build -> Artifacts -> omnitrix-mod-jar. Внутри будет jar.
Вариант B — локально: установите JDK 17 и Gradle 8.1.1, запустите build.bat (Windows) или build.sh.
Jar появится в build/libs/. Закиньте его в папку mods (Forge 1.20.1).

## Управление (Омнитрикс в руке)
- Shift+ПКМ — выбрать пришельца; ПКМ — превратиться
- В форме: ПКМ — способность, Shift+ПКМ — вернуться
Форма 2 мин, перезарядка после возврата 10 с. Рецепт: IEI / EDE / IEI (железо, изумруд, алмаз).

## Модели
Лежат в src/main/java/.../client/AlienModelData.java и textures/entity/*.png.
Они генерируются скриптом tools/gen_models.py (python3 tools/gen_models.py) — правьте кубы и цвета там.
