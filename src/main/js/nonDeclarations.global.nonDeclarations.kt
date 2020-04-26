@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")
package global

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

inline var NotificationOptions.timeout: Number? get() = this.asDynamic().timeout; set(value) { this.asDynamic().timeout = value }

typealias MessageEventHandler = (pluginMessage: Any, props: OnMessageProperties) -> Unit

typealias VectorPaths = Array<VectorPath>

inline var Image.hash: String get() = this.asDynamic().hash; set(value) { this.asDynamic().hash = value }

/* extending interface from lib.dom.d.ts */
inline fun Image.getBytesAsync(): Promise<Uint8Array> = this.asDynamic().getBytesAsync()