//pour gerer toute forme d'exception controlee.

package tec;//se trouvant dans le répertoir src.

public class TecException extends Exception{//la classe dont on a parlé avant
    //dans tous les commentaires.

    public TecException(String message){
	super(message);
    }
    //enonce: ou en precisant une autre exception
    //via ?
    //=>Throwable cause(throws throw Throwable)
    //appel a super car deux constructeurs en override + heritage
    //et la classe Exception prend en compte ceci
    //par exemple throw new IllegalStateException(String) voila
    //ou bien throw new(qlq.chose qualifee de Throwable(exception))
    //precisant ainsi une autre exception.

    //possible.
    public TecException(Throwable cause){
	super(cause);
    }
    //HERITAGE.
}
