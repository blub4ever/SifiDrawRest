package eu.glatz.sifidraw.config

object SecurityConstants {
    const val SECRET = "SecretKeyToGenJWTs"
    const val EXPIRATION_TIME: Long = 864000000 // 10 days
    const val TOKEN_PREFIX = "Bearer "
    const val HEADER_STRING = "Authorization"
    const val SIGN_UP_URL = "SifiDrawRest/user/sign-up"
    const val SIGN_IN = "/SifiDrawRest/login"
}