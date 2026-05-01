# Shizuku Game Optimizer

Простой Android-проект на Kotlin для оптимизации устройства под игры через Shizuku.

## Что умеет
- Проверка подключения Shizuku.
- Подготовка набора команд для снижения анимаций и включения фиксированного performance-режима.

## Важно
Приложение показывает команды для запуска через shell Shizuku. Перед использованием:
1. Установи и запусти Shizuku.
2. Выдай приложению разрешение Shizuku.
3. Запускай команды только если понимаешь их эффект на устройство.

## Как собрать APK

### В Android Studio (самый простой способ)
1. Открой проект `AiApp` в Android Studio.
2. Дождись синхронизации Gradle.
3. Нажми **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
4. После сборки нажми ссылку **locate** в уведомлении.

Готовый файл обычно лежит по пути:
`app/build/outputs/apk/debug/app-debug.apk`

### Через терминал
```bash
./gradlew assembleDebug
```

Если нужен релизный APK:
```bash
./gradlew assembleRelease
```

Результат:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`
