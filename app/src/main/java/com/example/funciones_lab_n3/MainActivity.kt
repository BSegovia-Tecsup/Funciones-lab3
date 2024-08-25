package com.example.funciones_lab_n3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funciones_lab_n3.ui.theme.FuncionesLABN3Theme
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuncionesLABN3Theme {
                ScaffoldExample()
            }
        }
    }
}

@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = { TopAppBarExample() },
        floatingActionButton = { FloatingActionButtonExample() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFE0F7FA)) // Fondo azul claro
        ) {
            CardExample()
            Spacer(modifier = Modifier.height(16.dp))
            AlertDialogExample()
            Spacer(modifier = Modifier.height(16.dp))
            CheckboxExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    CenterAlignedTopAppBar(
        title = { Text("Barra de Aplicación", color = Color.White) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF00796B)) // Color verde oscuro
    )
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = { /* Acción del FAB */ }) {
        Text("FAB", color = Color.White)
    }
}

@Composable
fun CardExample() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2DFDB)) // Color verde claro
    ) {
        Text(
            text = "Ejemplo de Tarjeta",
            modifier = Modifier
                .padding(16.dp)
                .background(Color(0xFF00796B)), // Color verde oscuro
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun AlertDialogExample() {
    var openDialog by remember { mutableStateOf(false) }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = { openDialog = false },
            title = { Text("Diálogo de Alerta", color = Color(0xFF00796B)) },
            text = { Text("Este es un ejemplo de un AlertDialog.", color = Color.Black) },
            confirmButton = {
                Button(onClick = { openDialog = false }) {
                    Text("Aceptar")
                }
            }
        )
    }

    Button(onClick = { openDialog = true }) {
        Text("Mostrar AlertDialog")
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Ejemplo de Checkbox", fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScaffoldExample() {
    FuncionesLABN3Theme {
        ScaffoldExample()
    }
}
