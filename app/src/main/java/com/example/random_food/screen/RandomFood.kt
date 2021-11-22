package com.example.random_food.screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.random_food.R
import com.example.random_food.models.FoodModel
import com.example.random_food.view.SampleDataGridItem
import kotlinx.coroutines.launch


private val foodItems = listOf(
    FoodModel(
        "banh kem dau",
        "200000",
        R.drawable.banhkem1
    ),
    FoodModel(
        "banh kem dau",
        "250000",
        R.drawable.banhkem2
    ),
    FoodModel(
        "banh kem dau",
        "300000",
        R.drawable.banhkem3
    ),
    FoodModel(
        "banh kem dau",
        "400000",
        R.drawable.banhkem4
    ),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FoodList(
    foodModels: List<FoodModel>,
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ){
        items(foodModels){ foodModel ->
            FoodItem(name = foodModel.name, price = foodModel.price , image = foodModel.image)
    }
}
}

@ExperimentalMaterialApi
@Composable
fun FoodScreen(navHostController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var random by remember {
        mutableStateOf(-1)
    }

    var onClickDialog = remember { mutableStateOf(false)  }
    Scaffold(

        topBar = {
           TopAppBar(
                title = "Food Random",
                icon = Icons.Filled.List,
                onIconClick = {
                    navHostController.navigate("food_data")
                    }
            )
        },
//        floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = { FloatingActionButton(onClick = {}){
//            Text("X")
//        } },
        scaffoldState = scaffoldState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                FoodList(foodModels = foodItems)
                RandomButton{
                    random = kotlin.random.Random.nextInt(0, foodItems.size - 1)
                    onClickDialog.value = true
                }

//                Text(text = foodItems.toString())

            }
            if (onClickDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        onClickDialog.value = false
                    },
                    text = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Food Random",
                                style = TextStyle(
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Red
                                ),
                                modifier = Modifier.padding(bottom = 32.dp)
                            )
                            FoodItem(
                                name = foodItems[random].name,
                                price = foodItems[random].price,
                                image = foodItems[random].image,
                            )
                        }
                    },
                    confirmButton = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Button(
                                onClick = {
                                    onClickDialog.value = false
                                }) {
                                Text("Oke")
                            }
                        }
                    },
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                Text(text = "My house")
            }
        }
//        bottomBar = { BottomAppBar(backgroundColor = Color.Black) { } }
    )
}
//@Composable
//fun AlertDialogSample() {
//    MaterialTheme {
//        Column {
//            val openDialog = remember { mutableStateOf(false)  }
//
//            Button(onClick = {
//                openDialog.value = true
//            }) {
//                Text("Random Button")
//            }
//
//            if (openDialog.value) {
//
//                AlertDialog(
//                    onDismissRequest = {
//                        openDialog.value = false
//                    },
//                    title = {
//                        Text(text = "Dialog Title")
//                    },
//                    text = {
//                        Text("Here is a text ")
//                    },
//                    confirmButton = {
//                        Button(
//
//                            onClick = {
//                                openDialog.value = false
//                            }) {
//                            Text("This is the Confirm Button")
//                        }
//                    },
//                    dismissButton = {
//                        Button(
//
//                            onClick = {
//                                openDialog.value = false
//                            }) {
//                            Text("This is the dismiss Button")
//                        }
//                    }
//                )
//            }
//        }
//
//    }
//}

@Composable
fun SampleDataGridItem() {
    Card(
        modifier = androidx.compose.ui.Modifier
            .padding(10.dp)
            .fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier.padding(10.dp)
        )
        {
            Image(
                painterResource(R.drawable.banhkem3),
                contentDescription = "Food Image",
                modifier = androidx.compose.ui.Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(modifier = androidx.compose.ui.Modifier.padding(3.dp))
            Text(
                text = "name",
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = androidx.compose.ui.Modifier.padding(5.dp))
            Text(
                text = "",
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
