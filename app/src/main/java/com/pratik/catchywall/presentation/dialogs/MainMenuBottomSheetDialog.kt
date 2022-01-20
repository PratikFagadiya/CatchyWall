package com.pratik.catchywall.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pratik.catchywall.databinding.DialogBottomsheetMainMenuBinding

class MainMenuBottomSheetDialog : BottomSheetDialogFragment() {

    lateinit var dialogBottomSheetMainMenuBinding: DialogBottomsheetMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dialogBottomSheetMainMenuBinding =
            DialogBottomsheetMainMenuBinding.inflate(inflater, container, false)

        return dialogBottomSheetMainMenuBinding.root
    }
}