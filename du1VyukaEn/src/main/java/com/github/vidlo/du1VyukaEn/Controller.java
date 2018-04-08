package com.github.vidlo.du1VyukaEn;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Kontroler
 *
 */
public class Controller extends VBox {

	private int lastPick = 0;
	private String pickGuess = "";
	private String guess = "";
	@FXML private Label animalEn;
	@FXML private Label correct;
	@FXML private Label incorrect;
	@FXML private Button horse;
	@FXML private Button cow;
	@FXML private Button goat;
	@FXML private Button sheep;
	@FXML private Button hen;
	@FXML private Button dog;
	@FXML private MenuItem newGame;
	@FXML private MenuItem endGame;
	
	
	/**
	 * Metoda uklada do premennej zviera [uzivatel]
	 * @param zviera
	 */
	public void setPickGuess(String guess){
		pickGuess = guess;
	}
	
	/**
	 * Metoda vracia nazov zvierata
	 */
	public String getPickGuess(){
		return pickGuess;
	}
	
	/**
	 * Metoda uklada do premennej zviera [program]
	 * @param zviera
	 */
	public void setGuess(String guess){
		this.guess = guess;
	}
	
	/**
	 * Metoda vracia nazov zvierata
	 */
	public String getGuess(){
		return guess;
	}
	
	/**
	 * Metoda nastavuje cislo zvierata
	 * @param cislo zvierata
	 */
	public void setLast(int number){
		lastPick = number;
	}
	
	/**
	 * Metoda vracia posledne hladane zviera
	 */
	public int getLast(){
		return lastPick;
	}
	
	/**
	 * Pricitavanie spravnych odpovedi
	 */
	public void setCorrect(){
		int number = Integer.parseInt(getCorrect()) + 1;
		correct.setText(Integer.toString(number));
	}
	
	/**
	 * Metoda vracia pocet spravnych odpovedi
	 */
	public String getCorrect(){
		return correct.getText();
	}
	
	/**
	 * Pricitavanie nespravnych odpovedi
	 */
	public void setIncorrect(){
		int cislo = Integer.parseInt(getIncorrect()) + 1;
		incorrect.setText(Integer.toString(cislo));
	}
	
	/**
	 * Metoda vracia pocet nespravnych odpovedi
	 */
	public String getIncorrect(){
		return incorrect.getText();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture1(){
		setPickGuess("horse");
		checkGuess();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture2(){
		setPickGuess("cow");
		checkGuess();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture3(){
		setPickGuess("goat");
		checkGuess();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture4(){
		setPickGuess("sheep");
		checkGuess();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture5(){
		setPickGuess("hen");
		checkGuess();
	}
	
	/**
	 * Po klikniuti nastavi nazov zvierata do premennej
	 */
	public void picture6(){
		setPickGuess("dog");
		checkGuess();
	}
	
	/**
	 * Metoda kontroluje spravnost odpovedi
	 * Zobrazi sa dialogove okno
	 */
	public void checkGuess(){
		if(getPickGuess() == getGuess()){
			setCorrect();
			JOptionPane.showMessageDialog(null, "Správne! \nCorrect!");
			randomGuess();
		}
		else{
			setIncorrect();
			JOptionPane.showMessageDialog(null, "Špatně!\n Incorrect!");
		}
	}
	
	/**
	 * Metoda generuje nazov zvierata
	 * Kontrola stejnosti dvoch zvierat za sebou
	 */
	public void randomGuess(){
		Random random = new Random();
		int  lastPick = random.nextInt(6) + 1;
		if(lastPick == getLast()) {
			while (lastPick == getLast()) {
				lastPick = random.nextInt(6) + 1;
			}
		}
		switch (lastPick) {
			case 1:  setGuess("horse");
                break;
			case 2:  setGuess("cow");
                break;
			case 3:  setGuess("goat");
				break;
			case 4:  setGuess("sheep");
                break;
			case 5:  setGuess("hen");
                break;
			case 6:  setGuess("dog");
                break;
        
			default: setGuess("horse");
                break;
		}
		animalEn.setText(getGuess());
		setLast(lastPick);
		horse.setDisable(false);
		cow.setDisable(false);
		goat.setDisable(false);
		sheep.setDisable(false);
		hen.setDisable(false);
		dog.setDisable(false);
	}
	
	/**
	 * Pociatocna metoda
	 */
	public void inicializuj() {
	}
	
	/**
	 * Metoda nastavi novu hru
	 */
	public void newGame() {
		correct.setText("0");
		incorrect.setText("0");
		animalEn.setText("");
		horse.setDisable(true);
		cow.setDisable(true);
		goat.setDisable(true);
		sheep.setDisable(true);
		hen.setDisable(true);
		dog.setDisable(true);
	}
	
	/**
	 * Metoda zavrie okno
	 */
	public void endGame() {
		System.exit(0);
	}

}
