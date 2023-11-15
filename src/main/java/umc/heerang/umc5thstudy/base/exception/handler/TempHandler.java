package umc.heerang.umc5thstudy.base.exception.handler;

import umc.heerang.umc5thstudy.base.code.BaseErrorCode;
import umc.heerang.umc5thstudy.base.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
