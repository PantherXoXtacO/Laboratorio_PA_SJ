package Publicador;


import DataType.*;
import Enums.*;
import Logica.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
    public Publicador(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9130/publicador", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    @WebMethod
    public DTUsuario getUserData(String nick){
        IControlador controlador = new Controlador();
        return controlador.getUserData(nick);
    }
    @WebMethod
    public void WebAltaCliente(String nick, String mail, String fecha, String pass, String nombre, String apellido){
        IControlador controlador = new Controlador();
        controlador.WebAltaCliente(nick, mail, fecha, pass, nombre, apellido);
    }
    @WebMethod
    public  void actualizarEstadoDeSuscripcionWeb(Cliente cliente, EstadosDeSuscripcion estado){
        IControlador controlador = new Controlador();
        controlador.actualizarEstadoDeSuscripcionWeb(cliente, estado);
    }
    @WebMethod
    public  void contratarSuscripcion(Cliente cliente, TiposDeSuscripcion tipo){
        IControlador controlador = new Controlador();
        controlador.contratarSuscripcion(cliente, tipo);
    }
    @WebMethod
    public  DataSession getUserSession(String identificador, String pass){
        IControlador controlador = new Controlador();
        return controlador.getUserSession(identificador, pass);
    }
    @WebMethod
    public  void addListaParticular(String user, String nombreLista, String img){
        IControlador controlador = new Controlador();
        controlador.addListaParticular(user, nombreLista, img);
    }
    @WebMethod
    public  void AgregarTemaListaWeb(String user, String lista, String artista, String album, String tema){
        IControlador controlador = new Controlador();
        controlador.AgregarTemaListaWeb(user, lista, artista, album, tema);
    }
    @WebMethod
    public  void ActualizarImagenUsuario(String UserNick, String path){
        IControlador controlador = new Controlador();
        controlador.ActualizarImagenUsuario(UserNick, path);
    }
    @WebMethod
    public  void ActualizarImagenAlbum(String AlbumNombre, String path){
        IControlador controlador = new Controlador();
        controlador.ActualizarImagenAlbum(AlbumNombre, path);
    }
    
    @WebMethod
    public  ArrayList<String> GenerosToString(ArrayList<Genero> generos){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.GenerosToString(generos);
    }
    @WebMethod
    public  ArrayList<Genero> GenerosFromString(String generos){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.GenerosFromString(generos);
    }
    @WebMethod
    public  String imprimirListaDeGeneros(ArrayList<Genero> generos){
        IControlador controlador = new Controlador();
        return controlador.imprimirListaDeGeneros(generos);
    }
    @WebMethod
    public  ArrayList<String> getGenerosInString(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getGenerosInString();
    }
    @WebMethod
    public  ArrayList<Genero> getGeneros(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getGeneros();
    }
    @WebMethod
    public  ArrayList<String> getArtistas(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getArtistas();
    }
    @WebMethod
    public  ArrayList<Album> getAlbumsList(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getAlbumsList();
    }
    @WebMethod
    public  Album getAlbumByName(String albumname){
        IControlador controlador = new Controlador();
        return controlador.getAlbumByName(albumname);
    }
    @WebMethod
    public  ArrayList<String> getAlbumsListtoString(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getAlbumsListtoString();
    }
    @WebMethod
    public  String albumListToString(ArrayList<Album> albums){
        IControlador controlador = new Controlador();
        return controlador.albumListToString(albums);
    }
    @WebMethod
    public  void DejarDeSeguirUsuario(String seguidor, String seguido){
        IControlador controlador = new Controlador();
        controlador.DejarDeSeguirUsuario(seguidor, seguido);
    }
    @WebMethod
    public  void SeguirUsuario(String seguidor, String seguido){
        IControlador controlador = new Controlador();
        controlador.SeguirUsuario(seguidor, seguido);
    }
    @WebMethod
    public  HashMap getListasConNombre(String nombreLista){
        IControlador controlador = new Controlador();
        return (HashMap)controlador.getListasConNombre(nombreLista);
    }
    @WebMethod
    public Cliente consultarCliente(String nickname){
        IControlador controlador = new Controlador();
        return controlador.consultarCliente(nickname);
    }
    
    @WebMethod
    public Artista consultarArtista(String nickname){
        IControlador controlador = new Controlador();
        return controlador.consultarArtista(nickname);
    }
    @WebMethod
    public void configTemporalAlbum(Artista artist, String nombre, ArrayList<Genero> generos, int año, String imagePath){
        IControlador controlador = new Controlador();
        controlador.configTemporalAlbum(artist, nombre, generos, año, imagePath);
    }
    
    @WebMethod
    public void addTemporalAlbum(){
        IControlador controlador = new Controlador();
        controlador.addTemporalAlbum();
    }
    
    @WebMethod
    public void deleteTemporalAlbum(){
        IControlador controlador = new Controlador();
        controlador.deleteTemporalAlbum();
    }
    
    @WebMethod
    public void wipeTemporalGenres(){
        IControlador controlador = new Controlador();
        controlador.wipeTemporalGenres();
    }
    
    @WebMethod
    public boolean nicknameLibre(String nickname){
        IControlador controlador = new Controlador();
        return controlador.nicknameLibre(nickname);
    }
    
    @WebMethod
    public boolean mailLibre(String mail){
        IControlador controlador = new Controlador();
        return controlador.mailLibre(mail);
    }
    
    @WebMethod
    public void registrarCliente(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen){
        IControlador controlador = new Controlador();
        controlador.registrarCliente(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);        
    }
    
    @WebMethod
    public void registrarArtista(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen,
                    String biografia, String dir_web){
        IControlador controlador = new Controlador();
        controlador.registrarArtista(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen, biografia, dir_web);
    }
    
    
    @WebMethod    
    public Genero getGeneroPorNombre(String nombre){
        IControlador controlador = new Controlador();
        return controlador.getGeneroPorNombre(nombre);
    }
    @WebMethod
    public ArrayList<Genero> getTemporalGenres(){
        IControlador controlador = new Controlador();
        return (ArrayList)controlador.getTemporalGenres();
    }
    @WebMethod
    public Album getTemporalAlbum(){
        IControlador controlador = new Controlador();
        return controlador.getTemporalAlbum();
    }
    @WebMethod
    public void createTemporalAlbum(){
        IControlador controlador = new Controlador();
        controlador.createTemporalAlbum();
    }
    @WebMethod
    public void createTemporalGenres(){
        IControlador controlador = new Controlador();
        controlador.createTemporalGenres();
    }
    @WebMethod
    public void AltaGenero(String nombre, String padre){
        IControlador controlador = new Controlador();
        controlador.AltaGenero(nombre, padre);
    }
    
    
    
    //////////////////////Funciones que no retornan nada, solo para incluir los .java
    @WebMethod
    public DTCliente dtCliente(){
        return null;
    }
    
    @WebMethod
    public Tema tema(){
        return null;
    }
    
    @WebMethod
    public DTListaRepro dtLista(){
        return null;
    }
    
    @WebMethod
    public DTArtista dtArtista(){
        return null;
    }
    
    @WebMethod
    public DTListaPrticular dtListaParticular(){
        return null;
    }
    
    @WebMethod
    public DTTema dtTema(){
        return null;
    }
    
    @WebMethod
    public DTAlbum dtAlbum(){
        return null;
    }
    
    @WebMethod
    public DTListaDefecto dtListaDef(){
        return null;
    }
    
}
