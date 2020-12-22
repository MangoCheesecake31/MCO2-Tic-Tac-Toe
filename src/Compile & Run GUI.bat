:: BATCH SCRIPT FOR COMPILING & RUNNING CODE
@ECHO OFF

:: Set FX Library Path
set PATH_TO_FX="C:\Program Files\Java\javafx-sdk-11.0.2\lib"

:: Compile all contorller classes with javafx
javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.graphics controller/*.java

:: Compile DriverGUI with javafx
javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.graphics driver/DriverGUI.java

:: Run DriverGUI
java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.graphics driver.DriverGUI
:: End	