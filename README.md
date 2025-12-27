# Java Drawing Application

A simple Java Swing-based drawing application that allows users to draw various shapes with different colors and styles.

## Features

- **Drawing Tools:**
  - Line
  - Rectangle
  - Oval
  - Pencil (freehand drawing)
  - Eraser

- **Color Options:**
  - Black
  - Red
  - Green
  - Blue

- **Styling Options:**
  - Solid or Dotted lines
  - Filled or unfilled shapes

- **Additional Features:**
  - Clear canvas
  - Undo last action

## Requirements

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

## How to Run

### Option 1: Using Command Line

1. **Clone the repository:**
   ```bash
   git clone https://github.com/saadaltohamy/Saad-Paint.git
   cd Saad-Paint
   ```

2. **Compile all Java files:**
   ```bash
   javac finalProject/*.java
   ```

3. **Run the application:**
   ```bash
   java finalProject.Main
   ```

### Option 2: Using an IDE (Eclipse, IntelliJ IDEA, NetBeans)

1. Open the project folder in your IDE
2. Locate the `Main.java` file
3. Right-click on `Main.java` and select **Run** or **Run As → Java Application**

### Option 3: Using VS Code

1. Open the project folder in VS Code
2. Open `Main.java`
3. Click the **Run** button above the `main` method
4. Or press `F5` to run the application

## How to Use

1. **Select a Tool:** Click on one of the shape buttons (Line, Rect, Oval, Pencil, Eraser)
2. **Choose a Color:** Click on a color button (Black, Red, Green, Blue)
3. **Set Style Options:**
   - Check "Solid" or "Dotted" for line style
   - Check "Fill" to fill shapes with color
4. **Draw:** Click and drag on the canvas to draw
5. **Clear:** Click the "Clear" button to remove all drawings
6. **Undo:** Click the "Undo" button to remove the last drawn shape

## Project Structure

```
Saad-Paint/
├── Main.java         # Entry point of the application
├── MyPanel.java      # Main panel with drawing canvas and UI controls
├── Shape.java        # Abstract base class for all shapes
├── Line.java         # Line shape implementation
├── Rectangle.java    # Rectangle shape implementation
├── Oval.java         # Oval shape implementation
├── Pencil.java       # Freehand drawing implementation
└── README.md         # This file
```

## Author
Saad Al-Tohamy  
ITI Java Course Final Project

