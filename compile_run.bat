@echo off
chcp 65001 >nul 2>&1
echo ========================================
echo КОМПИЛЯЦИЯ И ЗАПУСК
echo ========================================
echo.

javac -d target/classes src/main/java/com/library/*.java src/main/java/com/library/model/*.java src/main/java/com/library/dao/*.java src/main/java/com/library/service/*.java src/main/java/com/library/ui/*.java

if errorlevel 1 (
    echo ОШИБКА: Не удалось скомпилировать!
    pause
    exit /b 1
)

echo.
echo ЗАПУСК...
echo.
java -cp target/classes com.library.Main

pause