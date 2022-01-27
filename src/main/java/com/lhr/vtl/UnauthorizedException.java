package com.lhr.vtl;

import com.lhr.vtl.TemplateException;

public class UnauthorizedException extends TemplateException {
    UnauthorizedException() {
        super("Unauthorized");
    }
}
