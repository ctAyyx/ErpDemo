package com.ct.erp.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.ct.erp.R

class CommonSpinnerAdapter(context: Context, data: List<String>) :
    ArrayAdapter<String>(context, R.layout.item_common_spinner, R.id.tvItemCommonSpinner, data)