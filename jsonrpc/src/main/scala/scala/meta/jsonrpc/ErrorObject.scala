package scala.meta.jsonrpc

import io.circe.Json
import io.circe.derivation.annotations.JsonCodec

@JsonCodec case class ErrorObject(
    code: ErrorCode,
    message: String,
    data: Option[Json]
)
