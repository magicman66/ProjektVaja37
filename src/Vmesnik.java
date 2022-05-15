// Avtor: Maks Štempihar

// uvozimo paket swing
import javax.swing.*;

// uvozimo paket za delo z dogodki
import java.awt.event.*;

// deklariramo javni razred Vmesnik, ki razširja razred Jframe
public class Vmesnik extends JFrame implements ActionListener{
	
	// deklariramo lastnosti za uporabniški vmesnik
	private JPanel povrsina;
	
	private JLabel besediloProgram;
	private JTextField vnosnoPoljeProgram;	
	private JLabel besediloGlasnost;
	private JTextField vnosnoPoljeGlasnost;
	private JLabel besediloDiagonala;
	private JTextField vnosnoPoljeDiagonala;	
	private JLabel besediloTemperatura;
	private JTextField vnosnoPoljeTemperatura;	
	
	private JButton gumb;
	private TelevizorTableModel modelTabele;
	private JTable tabela;
	
	// deklariramo konstruktor
	public Vmesnik(String l){
		
		// kličemo konstruktor nadrazreda
		super(l);
		
		// inicializiramo lastnosti objekta
		povrsina = new JPanel();
		
		besediloProgram = new JLabel("Program: ");
		vnosnoPoljeProgram = new JTextField(32);
		besediloGlasnost = new JLabel("Glasnost: ");
		vnosnoPoljeGlasnost = new JTextField(32);
		besediloDiagonala = new JLabel("Diagonala: ");
		vnosnoPoljeDiagonala = new JTextField(32);
		besediloTemperatura = new JLabel("Temperatura: ");
		vnosnoPoljeTemperatura = new JTextField(32);
		
		gumb = new JButton("Dodaj");
		modelTabele = new TelevizorTableModel();
		tabela = new JTable(modelTabele);
		
		// gumbu dodamo posušalca dogodkov
		// kot vhodni podatek mu dodaamo kazalec na samega sebe
		gumb.addActionListener(this);
		
		// površino dodamo v okno
		add(povrsina); 
		
		// vnosna polja dodamo na površino
		povrsina.add(besediloProgram);
		povrsina.add(vnosnoPoljeProgram);
		povrsina.add(besediloGlasnost);
		povrsina.add(vnosnoPoljeGlasnost);
		povrsina.add(besediloDiagonala);
		povrsina.add(vnosnoPoljeDiagonala);
		povrsina.add(besediloTemperatura);
		povrsina.add(vnosnoPoljeTemperatura);
		
		// gumb in tabelo dodamo na površino
		povrsina.add(gumb);
		povrsina.add(tabela);
		
		// prikažemo okno - kličemo metodo nadrazreda
		setVisible(true);
		
		// nastavimo obnašanje gumbka za zapiranje - naj konča aplikacijo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// nastavimo privzeto velikost okna
		setSize(800, 600); 
		
		System.out.println("postavljam Vmesnik " + l);
	}
	
	// deklariramo javno statično metodo za zagon programa
	// vhodi: seznam nizov z argumenti za zagon
	// izhodi: /
	public static void main(String[] args){
		
		if(args.length > 0){
			System.out.println("Postavljam Vmesnik" + args[0]);
				
			// Ustvarimo objekt(lokalno spremenljivko)
			Vmesnik m = new Vmesnik(args[0]);
		}
		else{
			System.out.println("Ne morem postaviti vmesnika brez lokacije");
			System.out.println("Uporaba:");
			System.out.println("Java vmesnik lokacija vmesnika");
		}
	}	
	
	// javna metoda, ki jo predpisuje vmesnik
	public void actionPerformed(ActionEvent e){
		System.out.println("Gumb pritisni!");
		
		// pretvorimo string v double
		double sa =  Double.parseDouble(vnosnoPoljeTemperatura.getText());
		
		// dodamo nov zapis v tabelo
		// v model tabele dodamo testno pivsko steklenico
		modelTabele.addRazsirjenoEna(new RazsirjenoEna(Integer.parseInt(vnosnoPoljeProgram.getText()) ,Integer.parseInt(vnosnoPoljeGlasnost.getText()), vnosnoPoljeDiagonala.getText(), sa));
	}
}