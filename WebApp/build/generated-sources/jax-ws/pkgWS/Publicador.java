
package pkgWS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Publicador", targetNamespace = "http://Publicador/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Publicador {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/actualizarEstadoDeSuscripcionWebRequest", output = "http://Publicador/Publicador/actualizarEstadoDeSuscripcionWebResponse")
    public void actualizarEstadoDeSuscripcionWeb(
        @WebParam(name = "arg0", partName = "arg0")
        Cliente arg0,
        @WebParam(name = "arg1", partName = "arg1")
        EstadosDeSuscripcion arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/contratarSuscripcionRequest", output = "http://Publicador/Publicador/contratarSuscripcionResponse")
    public void contratarSuscripcion(
        @WebParam(name = "arg0", partName = "arg0")
        Cliente arg0,
        @WebParam(name = "arg1", partName = "arg1")
        TiposDeSuscripcion arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/addListaParticularRequest", output = "http://Publicador/Publicador/addListaParticularResponse")
    public void addListaParticular(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "AgregarTemaListaWeb")
    @Action(input = "http://Publicador/Publicador/AgregarTemaListaWebRequest", output = "http://Publicador/Publicador/AgregarTemaListaWebResponse")
    public void agregarTemaListaWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "ActualizarImagenUsuario")
    @Action(input = "http://Publicador/Publicador/ActualizarImagenUsuarioRequest", output = "http://Publicador/Publicador/ActualizarImagenUsuarioResponse")
    public void actualizarImagenUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "ActualizarImagenAlbum")
    @Action(input = "http://Publicador/Publicador/ActualizarImagenAlbumRequest", output = "http://Publicador/Publicador/ActualizarImagenAlbumResponse")
    public void actualizarImagenAlbum(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod(operationName = "GenerosFromString")
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/GenerosFromStringRequest", output = "http://Publicador/Publicador/GenerosFromStringResponse")
    public ArrayList generosFromString(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/imprimirListaDeGenerosRequest", output = "http://Publicador/Publicador/imprimirListaDeGenerosResponse")
    public String imprimirListaDeGeneros(
        @WebParam(name = "arg0", partName = "arg0")
        ArrayList arg0);

    /**
     * 
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getGenerosInStringRequest", output = "http://Publicador/Publicador/getGenerosInStringResponse")
    public ArrayList getGenerosInString();

    /**
     * 
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getAlbumsListtoStringRequest", output = "http://Publicador/Publicador/getAlbumsListtoStringResponse")
    public ArrayList getAlbumsListtoString();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/albumListToStringRequest", output = "http://Publicador/Publicador/albumListToStringResponse")
    public String albumListToString(
        @WebParam(name = "arg0", partName = "arg0")
        ArrayList arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "DejarDeSeguirUsuario")
    @Action(input = "http://Publicador/Publicador/DejarDeSeguirUsuarioRequest", output = "http://Publicador/Publicador/DejarDeSeguirUsuarioResponse")
    public void dejarDeSeguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.HashMap
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getListasConNombreRequest", output = "http://Publicador/Publicador/getListasConNombreResponse")
    public HashMap getListasConNombre(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/configTemporalAlbumRequest", output = "http://Publicador/Publicador/configTemporalAlbumResponse")
    public void configTemporalAlbum(
        @WebParam(name = "arg0", partName = "arg0")
        Artista arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        ArrayList arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/deleteTemporalAlbumRequest", output = "http://Publicador/Publicador/deleteTemporalAlbumResponse")
    public void deleteTemporalAlbum();

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/wipeTemporalGenresRequest", output = "http://Publicador/Publicador/wipeTemporalGenresResponse")
    public void wipeTemporalGenres();

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.Genero
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getGeneroPorNombreRequest", output = "http://Publicador/Publicador/getGeneroPorNombreResponse")
    public Genero getGeneroPorNombre(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.DtUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getUserDataRequest", output = "http://Publicador/Publicador/getUserDataResponse")
    public DtUsuario getUserData(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "WebAltaCliente")
    @Action(input = "http://Publicador/Publicador/WebAltaClienteRequest", output = "http://Publicador/Publicador/WebAltaClienteResponse")
    public void webAltaCliente(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns pkgWS.DataSession
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getUserSessionRequest", output = "http://Publicador/Publicador/getUserSessionResponse")
    public DataSession getUserSession(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @return
     *     returns pkgWS.Tema
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/temaRequest", output = "http://Publicador/Publicador/temaResponse")
    public Tema tema();

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod(operationName = "GenerosToString")
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/GenerosToStringRequest", output = "http://Publicador/Publicador/GenerosToStringResponse")
    public ArrayList generosToString(
        @WebParam(name = "arg0", partName = "arg0")
        ArrayList arg0);

    /**
     * 
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getGenerosRequest", output = "http://Publicador/Publicador/getGenerosResponse")
    public ArrayList getGeneros();

    /**
     * 
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getArtistasRequest", output = "http://Publicador/Publicador/getArtistasResponse")
    public ArrayList getArtistas();

    /**
     * 
     * @return
     *     returns pkgWS.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getAlbumsListRequest", output = "http://Publicador/Publicador/getAlbumsListResponse")
    public ArrayList getAlbumsList();

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.Album
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/getAlbumByNameRequest", output = "http://Publicador/Publicador/getAlbumByNameResponse")
    public Album getAlbumByName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "SeguirUsuario")
    @Action(input = "http://Publicador/Publicador/SeguirUsuarioRequest", output = "http://Publicador/Publicador/SeguirUsuarioResponse")
    public void seguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.Cliente
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/consultarClienteRequest", output = "http://Publicador/Publicador/consultarClienteResponse")
    public Cliente consultarCliente(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns pkgWS.Artista
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/consultarArtistaRequest", output = "http://Publicador/Publicador/consultarArtistaResponse")
    public Artista consultarArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/addTemporalAlbumRequest", output = "http://Publicador/Publicador/addTemporalAlbumResponse")
    public void addTemporalAlbum();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/nicknameLibreRequest", output = "http://Publicador/Publicador/nicknameLibreResponse")
    public boolean nicknameLibre(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/mailLibreRequest", output = "http://Publicador/Publicador/mailLibreResponse")
    public boolean mailLibre(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/registrarClienteRequest", output = "http://Publicador/Publicador/registrarClienteResponse")
    public void registrarCliente(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        Fecha arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg8
     */
    @WebMethod
    @Action(input = "http://Publicador/Publicador/registrarArtistaRequest", output = "http://Publicador/Publicador/registrarArtistaResponse")
    public void registrarArtista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        Fecha arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8);

    /**
     * 
     * @return
     *     returns pkgWS.DtCliente
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/dtClienteRequest", output = "http://Publicador/Publicador/dtClienteResponse")
    public DtCliente dtCliente();

    /**
     * 
     * @return
     *     returns pkgWS.DtListaRepro
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicador/Publicador/dtListaRequest", output = "http://Publicador/Publicador/dtListaResponse")
    public DtListaRepro dtLista();

}
