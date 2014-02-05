package de.lex.playground

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class XMainActivity extends Activity{
	
	override protected onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		setContentView(R$layout::main)
		findViewById(R$id::click).setOnClickListener[
			Toast::makeText(this, "Foo", Toast::LENGTH_LONG).show			
		]
	}
	
}