# TicTacToeFX
<p align="center">
  <img src="https://img.shields.io/github/v/release/karolsol/TicTacToeFX" alt="Latest Release">
  <img src="https://img.shields.io/github/actions/workflow/status/karolsol/TicTacToeFX/maven-test.yml?label=tests" alt="Tests">
  <img src="https://img.shields.io/github/license/karolsol/TicTacToeFX" alt="License">
</p>

A simple cross platform Tic-Tac-Toe game implemented in JavaFx using Maven.

## Screenshots
<div align="center">
  <img src="images/Screenshot_1.png" width="25%" style="margin-right: 15%; display: inline-block;">
  <img src="images/Screenshot_2.png" width="25%" style="display: inline-block;">
</div>

## Requirements

- Resonably new computer with Windows, Linux or MacOS(Intel based ones are **not** supported)
- Maven 3.9+(build and development only)

## Running the game(Windows)
With Powershell:
1. First you need to download TicTacToeFX.jar from Release on the right or by using command line:
```bach
wget https://github.com/karolsol/TicTacToeFX/releases/download/v0.0.3/TicTacToeFX-Windows.zip
```
2. Unzip it:
```bach
cd %USERPROFILE%\Downloads
Expand-Archive TicTacToeFX-Windows.zip .
```
3. And run:
```bach
TicTacToeFX\bin\ticTacToeFx.bat
```
or using GUI:
1. Open your download folder in file explorer, open right click menu and click unzip here option.
2. go to TicTacToeFX, then bin and double click on ticTacToeFx.bat

## Running the game(Mac and Linux)
With Powershell:
1. First you need to download TicTacToeFX.jar from Release on the right or by using command line:
```bach
wget https://github.com/karolsol/TicTacToeFX/releases/download/v0.0.3/TicTacToeFX-{Linux,Mac}.zip
```
2. Unzip it:
```bach
cd ~/Downloads
tar xf TicTacToeFX-{Linux,Mac}.tar.gz .
```
3. And run:
```bash
TicTacToeFX\bin\ticTacToeFx
```
or using GUI:
1. Open your download folder in file explorer, open right click menu and click unzip here option.
2. go to TicTacToeFX, then bin and double click on ticTacToeFx

## Build it yourself

```bash
mvn clean javafx:jlink
```
and run it exacly like from release.

## Testing

Run unit tests:

```bash
mvn test
```

## Running development version

```bash
mvn javafx:run
```

## License

This project is open source and available under the MIT License.

