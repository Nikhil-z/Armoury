package com.nikhil.armoury.utils

import android.accounts.AuthenticatorException
import java.lang.Exception


class ArmouryAuthException(ex: String = "The integrity check has not passed, resulting in denied authorization for Armoury") :
    AuthenticatorException(ex)

class ArmouryInitializerException(exception: String = "Unknown Exception") :
    RuntimeException(exception)