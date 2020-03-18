package com.eco4ndly.tracorona.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * A Sayan Porya code on 2020-02-08
 */

object Utils {
  const val MAX_RETRIES = 3L
  private const val INITIAL_BACKOFF = 500L

  fun getBackoffDelay(attempt: Long) = INITIAL_BACKOFF * (attempt + 1)

  fun shouldCallApi(
    lastApiCallMillis: Long,
    cacheThresholdInMillis: Long = 0L
  ): Boolean {
    if (cacheThresholdInMillis == 0L) {
      return true
    }
    return (System.currentTimeMillis() - lastApiCallMillis) >= cacheThresholdInMillis
  }

  fun getCurrentTimeStamp(): Long = System.currentTimeMillis()


  fun parseUTCTime(timestamp: String): String {
    val dateFormat =
      SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")

    val targetFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())

    return targetFormat.format(dateFormat.parse(timestamp))
  }

}

