package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Jugador {
	protected int idJugador;
	protected String nombre;
	protected String Fed;
	protected String titulo;

	protected float fide;
	protected int feda;
	
	protected float var;
	protected int edad;
	protected int k;
	public float getvar() {
		return var;
	}
	public void setvar(float var) {
		this.var = var;
	}
	public int getId() {
		return idJugador;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setK(int k) {
		this.k = k;
	}
	public Jugador(){
		this.idJugador = 0;
		this.nombre = "";
		this.Fed = "";
		this.k = 0;
		this.fide = 0;
		this.feda = 0;
		this.titulo = "-";
		this.var=0;
	}
	public Jugador( String nombre, String comu,int feda){
		this.nombre = nombre;
		this.feda = feda;
		this.Fed = comu;
	}
	public String getFed() {
		return Fed;
	}
	public int getFeda() {
		return feda;
	}
	public Jugador( String nombre, int fide,int k){
		this.nombre = nombre;
		this.fide = fide;
		this.k = k;
	}
	public Jugador( int id, String nombre, int fide, String titulo){
		this.idJugador = id;
		this.nombre = nombre;
		this.fide = fide;
		this.titulo = titulo;	
	}
	public Jugador( int id, String nombre, String Fed, int feda){
		this.idJugador = id;
		this.nombre = nombre;
		this.Fed = Fed;
		this.feda = feda;
		this.titulo = "-";
	
	}
	public Jugador( int id, String nombre, String Fed, int feda, String titulo){
		this.idJugador = id;
		this.nombre = nombre;
		this.Fed = Fed;
		this.feda = feda;
		this.titulo = titulo;
		
	}
	public Jugador( int id, String nombre, String Fed, int k,int feda, String titulo){
		this.idJugador = id;
		this.nombre = nombre;
		this.Fed = Fed;
		this.k = k;
		this.feda = feda;
		this.titulo = titulo;
		
	}
	public Jugador( int id, String nombre, String Fed, int fide,int feda){
		this.idJugador = id;
		this.nombre = nombre;
		this.fide = fide;
		this.Fed = Fed;
		this.feda = feda;		
	}
	public Jugador( int id, String nombre, String Fed, int k,int fide, int feda, String titulo){
		this.idJugador = id;
		this.nombre = nombre;
		this.Fed = Fed;
		this.k = k;
		this.fide = fide;
		this.feda = feda;
		this.titulo = titulo;
		
	}
	public Jugador(int id, String nombre, String titulo, float fide, int k, int edad) {
		// TODO Auto-generated constructor stub
		this.idJugador = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.fide = fide;
		this.k = k;
		this.edad = edad;
	}
	
	
	public String toString(){
		String cadena = "";
		cadena = this.idJugador+" "+this.nombre + " "+this.Fed+" "+this.fide +" "+
				" "+this.feda+" "+ this.k+" "+this.titulo+
				" "+this.var + " " +this.edad+"\n";
		return cadena;
	}
	public String getPartidas(int id) throws IOException  {
		String num = "";
		String url = "http://chess-db.com/public/pinfo.jsp?id="+id;
		URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
		
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));

        String inputLine;
        
        while ((inputLine = in.readLine()) != null){
			if(inputLine.trim().length()>4){
				
				if( inputLine.contains("<td style='text-align:center;'>Chess games")){
					int fin = inputLine.lastIndexOf("games")-1;
					
					while(inputLine.charAt(fin) != '>'){
						num =  inputLine.charAt(fin ) + num;
						fin--;
					}
		    		
		    	}
			}
			
					
				
		}
        in.close();
        return num;
	}
	
	public String insertSQL(){
		String sql =  "INSERT INTO `jugadores`(`idJugador`, `nombre`,`fed`, `titulo`, `fide`, `feda`, `var`, `edad`, `k`  )"
		 		+ " values ( "+idJugador+", '"+nombre.toUpperCase()+"', '"+Fed+"','"+titulo+"', "+fide+", "+feda+", "+var+", "+edad+", "+k+")";
		return sql;
	}
	public String insertSQLcambios(){
		String sql =  "INSERT INTO `cambios`(`idJugador`, `nombre`,`fed`, `titulo`, `fide`, `feda`, `var`, `edad`, `k`  )"
		 		+ " values ( "+idJugador+", '"+nombre.toUpperCase()+"', '"+Fed+"','"+titulo+"', "+fide+", "+feda+", "+var+", "+edad+", "+k+")";
		return sql;
	}
	public String updateSQLjugadores(){
		String sql ="UPDATE jugadores"
				+ "		SET `fide`="+fide+", `feda`="+feda+", `var`="+var+",`titulo`='"+titulo+"'"
				+ "		WHERE `idJugador` ="+idJugador;
		return sql;
	}
	public String updateSQLcambios(){
		String sql ="UPDATE cambios"
				+ "		SET `fide`="+fide+", `feda`="+feda+", `var`="+var+",`titulo`='"+titulo+"'"
				+ "		WHERE `idJugador` = "+idJugador;
		return sql;
	}
	public void setEdad(int anyoNac){
		this.edad = 2017 - anyoNac;
	}
	public void setFed(String Fed){
		this.Fed = Fed;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setVar(float var){
		    this.fide -=  this.var;
			this.var += var;
			this.fide += this.var;
	}
	public void addVar(float var) {
		// TODO Auto-generated method stub
		this.var += var;
		this.fide += var;
	}
	public int getK(){
		return this.k;
	}
	public void setFide(float d){
		this.fide = d;
	}
	public void setId(int id){
		
		this.idJugador = id;
	}
	public int getFide() {
		return (int) fide;
	}
	public void setFeda(int feda){
		this.feda = feda;
	}
	
	public void setTitulo(String string) {
		this.titulo = string;
		
	}

	
}