package umc.heerang.umc5thstudy.base.exception.handler;

import org.aspectj.apache.bcel.classfile.Code;
import umc.heerang.umc5thstudy.base.code.BaseErrorCode;
import umc.heerang.umc5thstudy.base.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
