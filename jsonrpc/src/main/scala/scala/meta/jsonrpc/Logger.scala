// scalafmt: { maxColumn = 120 }
package scala.meta.jsonrpc

trait Logger {
  def trace(message: => String)(implicit location: SourceLocation): Unit
  def trace(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit
  def debug(message: => String)(implicit location: SourceLocation): Unit
  def debug(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit
  def info(message: => String)(implicit location: SourceLocation): Unit
  def info(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit
  def warn(message: => String)(implicit location: SourceLocation): Unit
  def warn(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit
  def error(message: => String)(implicit location: SourceLocation): Unit
  def error(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit
}

object Logger {
  object StdoutLogger extends Logger {
    private def log(level: String, msg: => String, cause: Option[Throwable] = None)(
        implicit location: SourceLocation): Unit = {
      println(s"[$level] $location $msg")
      cause.foreach(_.printStackTrace(Console.out))
    }
    override def trace(message: => String)(implicit location: SourceLocation): Unit =
      log("trace", message)
    override def trace(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit =
      log("trace", message, Some(cause))
    override def debug(message: => String)(implicit location: SourceLocation): Unit =
      log("debug", message)
    override def debug(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit =
      log("debug", message, Some(cause))
    override def info(message: => String)(implicit location: SourceLocation): Unit =
      log("info", message)
    override def info(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit =
      log("info ", message, Some(cause))
    override def warn(message: => String)(implicit location: SourceLocation): Unit =
      log("warn", message)
    override def warn(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit =
      log("warn ", message, Some(cause))
    override def error(message: => String)(implicit location: SourceLocation): Unit =
      log("error", message)
    override def error(message: => String, cause: Throwable)(implicit location: SourceLocation): Unit =
      log("error", message, Some(cause))
  }
}
