package com.tme.userservice.config

import com.p6spy.engine.logging.Category
import com.p6spy.engine.spy.appender.MessageFormattingStrategy
import org.hibernate.engine.jdbc.internal.FormatStyle

class P6spySqlFormatter : MessageFormattingStrategy {

    override fun formatMessage(
        connectionId: Int,
        now: String?,
        elapsed: Long,
        category: String?,
        prepared: String?,
        sql: String?,
        url: String?
    ): String {
        return "$now | ${elapsed}ms | $category | connection $connectionId | url $url | ${formatSql(category, sql)}"
    }

    private fun formatSql(category: String?, sql: String?): String {
        if (sql.isNullOrBlank() || Category.STATEMENT.name != category) {
            return ""
        }

        val temp = sql.trim().lowercase()
        val formattedSql: String? =
            if (temp.startsWith("create") || temp.startsWith("alter") || temp.startsWith("comment")) {
                FormatStyle.DDL.formatter.format(sql)
            } else {
                FormatStyle.BASIC.formatter.format(sql)
            }
        return "\n User Service (P6Sqy SQL, Hibernate Format): ${formattedSql};"
    }
}