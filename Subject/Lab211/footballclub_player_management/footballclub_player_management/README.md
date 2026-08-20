# Football Club & Player Management - J1.L.P0036

Console application implemented for the LAB211 assignment **Football Club & Player Management**.

## Run in IntelliJ IDEA

1. Open the `footballclub_player_management` folder as a project.
2. Ensure the project uses JDK 8 or newer.
3. Run `src/Main.java`.
4. Keep `clubs.txt` and `players.txt` in the project root because the assignment requires these exact working file names.

## Structure

- `model`: abstract and domain model classes.
- `interfaces`: contracts implemented by the controllers.
- `controllers`: menu, club/player list logic, and file persistence.
- `utils/Inputter`: console input and input validation.
- `utils/Utils`: file reading and writing only.
- `view`: console application entry flow.

`clubs_1.txt` and `players_1.txt` are included as reference copies of the dataset shown in the assignment PDF. The application itself reads/writes `clubs.txt` and `players.txt` as required by the PDF.
