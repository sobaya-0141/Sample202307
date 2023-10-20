package sobaya.app.features.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen

class MainScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        icon = {
                            Icon(
                                painter = rememberVectorPainter(image = Icons.Default.Call),
                                contentDescription = null,
                            )
                        },
                        onClick = {},
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                elevation = LocalAbsoluteTonalElevation.current
                            ),
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.Gray,
                        ),
                    )
                    NavigationBarItem(
                        selected = false,
                        icon = {
                            Icon(
                                painter = rememberVectorPainter(image = Icons.Default.Home),
                                contentDescription = null,
                            )
                        },
                        onClick = {},
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                elevation = LocalAbsoluteTonalElevation.current
                            ),
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.Gray,
                        ),
                    )
                    NavigationBarItem(
                        selected = false,
                        icon = {
                            Icon(
                                painter = rememberVectorPainter(image = Icons.Default.Add),
                                contentDescription = null,
                            )
                        },
                        onClick = {},
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                elevation = LocalAbsoluteTonalElevation.current
                            ),
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.Gray,
                        ),
                    )
                }
            },
            content = {

            },
        )
    }
}