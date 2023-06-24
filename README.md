## Automated Newegg Checkout

Takes user inputs through JOption prompts, so that Selenium can automatically fill up every needed information to complete checkout on the desired Newegg Product.

## Table of Contents

- [Usage](#usage)
- [User Inputs](#userInputs)

## Usage

**1. Run Main.java File**
- ```
  python index.py
  ```
- Input CSV File Name:
  ```
  ymaze.csv
  ```
- Input Desired Output Text File Name:
  ```
  output.txt
  ```

**3. View Data from Console or Output Text File**
- Contains the number of Unique Arm Entries, Total Arm Entries and Individual Arm Entries
- Contains the patterns of Unique Arm Entries and Total Arm Entries 
- Contains every Individual Arm Entry (C, A, B, C, B, C, A, C, B, etc)
- The text file should be located within the root directory of the index.py file

## User Inputs

| Term    | Description                                    |
|---------|------------------------------------------------|
| Unique Arm Entry Pattern | Refers to the act of an animal entering three of the arms of the Y-Shaped Maze without repeating an arm entry within a specific period of time/trial (Ex: BAC, ABC, CBA).  |
| Arm Entry Pattern | Refers to the act of an animal entering three of the arms of the Y-Shaped Maze within a specific period of time/trial (Ex: AAC, CBC, ABC, BBA, CAB, etc). |
| Individual Arm Entry  | Refers to the act of an animal entering a single arm of the Y-Shaped Maze (Ex: C, A, B, C, B, C, A, C, B, etc).  |
| A | Refers to the 'In top' section from the CSV file; refers to the A-Arm of the Y-Maze |
| B | Refers to the 'In left' section from the CSV file; refers to the B-Arm of the Y-Maze |
| C | Refers to the 'In right' section from the CSV file; refers to the C-Arm of the Y-Maze |

![Example Y-Maze](y-shaped-maze.jpg)