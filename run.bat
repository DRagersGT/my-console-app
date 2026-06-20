@echo off
chcp 65001 >nul 2>&1
echo ========================================
echo ЗАПУСК ПРИЛОЖЕНИЯ
echo ========================================
echo.

if not exist target/classes (
    echo ОШИБКА: Проект не скомпилирован!
    echo Запустите compile.bat сначала.
    pause
    exit /b 1
)

java -cp target/classes com.library.Main

pause