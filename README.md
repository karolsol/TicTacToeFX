# Tic-Tac-Toe
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
- Maven 3.9+

## Building the project

```bash
mvn clean compile
```

## Running the game

```bash
mvn javafx:run
```

## Build JAR archive and run it

```bash
mvn clean package
java -jar target/TicTacToeFX.jar
```

## Testing

Run unit tests:

```bash
mvn test
```

## License

This project is open source and available under the MIT License.

