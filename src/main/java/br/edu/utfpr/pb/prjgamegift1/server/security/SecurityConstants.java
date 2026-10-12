package br.edu.utfpr.pb.prjgamegift1.server.security;

public class SecurityConstants {
    public static final String SECRET = "gamegift"; // secret utilizado para gerar o token
    public static final long EXPIRATION_TIME = 86400000L * 30; // 30 dia = 60*60*24*1000
    public static final String TOKEN_PREFIX = "Bearer "; // tipo da autenticação
    public static final String HEADER_STRING = "Authorization"; // header que será passado ao server com o token
}
