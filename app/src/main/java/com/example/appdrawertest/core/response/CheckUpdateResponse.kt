package com.example.appdrawertest.core.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "check", strict = false)
data class CheckUpdateResponse @JvmOverloads constructor(
    /**
     * codeVerified
     */
    @field:Element(name = "codeVerified")
    @param:Element(name = "codeVerified")
    var codeVerified: String? = null,

    /**
     * message
     */
    @field:Element(name = "message")
    @param:Element(name = "message")
    var message: String? = null,
)
