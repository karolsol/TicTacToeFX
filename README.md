# TicTacToeFX
<p align="center">
  <img src="https://img.shields.io/github/v/release/karolsol/TicTacToeFX" alt="Latest Release">
  <img src="https://img.shields.io/github/actions/workflow/status/karolsol/TicTacToeFX/maven-test.yml?label=tests" alt="Tests">
  <img src="https://img.shields.io/github/license/karolsol/TicTacToeFX" alt="License">
</p>

A simple Tic-Tac-Toe game implemented in JavaFx using Maven.

## Screenshots
<div align="center">
  <img src="images/Screenshot_1.png" width="25%" style="margin-right: 15%; display: inline-block;">
  <img src="images/Screenshot_2.png" width="25%" style="display: inline-block;">
</div>

## Requirements

- Java 16 or higher
- Maven 3.9+(build and development only)

## Running the game
1. First you need to download TicTacToeFX.jar from Release on the right or by using command line:
```bash
wget https://github.com/karolsol/TicTacToeFX/releases/download/v0.0.2/TicTacToeFX.jar
```
2. Then run it:
```bash
cd ~/Downloads
# or for Windows: 
#cd %USERPROFILE%\Downloads

java -jar TicTacToeFX.jar
```

## Build JAR archive yourself

```bash
mvn clean package
java -jar target/TicTacToeFX.jar
```

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

