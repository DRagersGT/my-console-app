@echo off
chcp 65001 >nul 2>&1
echo ========================================
echo КОМПИЛЯЦИЯ ПРОЕКТА
echo ========================================
echo.

javac -d target/classes src/main/java/com/library/*.java src/main/java/com/library/model/*.java src/main/java/com/library/dao/*.java src/main/java/com/library/service/*.java src/main/java/com/library/ui/*.java

if errorlevel 1 (
    echo ОШИБКА: Не удалось скомпилировать!
) else (
    echo КОМПИЛЯЦИЯ УСПЕШНО ЗАВЕРШЕНА!
)

pause