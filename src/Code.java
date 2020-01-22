/**
 * class to generate codes
 */
public class Code {
    private int code = 0;

    /**
     * new code
     */
    public Code(){
        code +=1;
    }

    /**
     *
     * @return code number
     */
    public int getCode() {
        return code;
    }

    /**
     * check if a code is not yet generated
     * @param lastCode last code
     * @return false if not yet generated, true otherwise
     */
    public boolean isValid(Code lastCode) {
        return (code<lastCode.getCode());
    }
}
