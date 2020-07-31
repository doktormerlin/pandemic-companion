package de.mdrone.pandemic_companion.ui.medicine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicineViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is medicine Fragment"
    }
    val text: LiveData<String> = _text
}