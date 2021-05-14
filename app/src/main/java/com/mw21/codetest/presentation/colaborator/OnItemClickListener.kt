package com.mw21.codetest.presentation.colaborator

import com.mw21.codetest.data.models.employee.Employee

interface OnItemClickListener {
    fun onItemClick(employee: Employee)
}