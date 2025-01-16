![image](https://github.com/user-attachments/assets/7fc938b6-08d3-4ecc-a31b-8193a72ab3d7)
## How to Run the Application

Follow these steps to set up and run the application:

1. **Clone the repository**  
   Run the following command to clone the repository to your local machine:
   ```bash
   git clone <URL_REPOSITORY>
2. **Navigate to project directory**
   ```bash
   cd project-name
3. **Run the app**
   
   On Linux:
   ```bash
   ./gradelw run
   ```
  
   On Windows:
   ```bash
   gradlew.bat run
   ```
   
## MainActivity Routing Code
![image](https://github.com/user-attachments/assets/f7090dfa-4522-438e-9079-bc57f547d33d)

```kotlin
val navController = rememberNavController()
```
Pada line ini membuat controller yang digunakan untuk mengatur navigasi antar layar.

## NavHost
Tempat mendefinisikan semua rute (screen) dalam aplikasi.
startDestination menentukan layar mana yang pertama kali dibuka (dalam kasus ini, LoginScreen).

```kotlin
composable<LoginScreen> { LoginScreen(navController) }
```
Mendefinisikan rute untuk layar LoginScreen.
Saat rute ini dipanggil, komponen LoginScreen akan dirender.
```kotlin
composable<HomeScreen> {HomeScreen(navController)}
```
Mendefinisikan rute untuk layar HomeScreen.
Saat rute ini dipanggil, komponen HomeScreen akan dirender.

```kotlin
composable<ProfileScreen> {ProfileScreen(navController)}
```
Mendefinisikan rute untuk layar ProfileScreen.
Saat rute ini dipanggil, komponen ProfileScreen akan dirender.

```kotlin
composable<RegisterScreen> {RegisterScreen(navController)}
```
Mendefinisikan rute untuk layar RegisterScreen.
Saat rute ini dipanggil, komponen RegisterScreen akan dirender.
```kotlin
composable<SettingsScreen> {SettingsScreen(navController)}
```
Mendefinisikan rute untuk layar SettingsScreen.
Saat rute ini dipanggil, komponen SettingsScreen akan dirender.

## Object
![image](https://github.com/user-attachments/assets/eb734603-10ac-4ad8-89fc-0c1e916fee48)
```kotlin
@Serializable:
```
Anotasi dari Kotlin Serialization yang memungkinkan objek ini untuk diubah menjadi format data seperti JSON.
Biasanya digunakan untuk mengirim atau menerima data antar sistem.

```kotlin
object
```
Objek-objek ini hanya sebagai penanda atau identitas untuk setiap layar (screen) di aplikasi.

## Bottom Navbar Navigation
![image](https://github.com/user-attachments/assets/16ea36ba-0989-46a4-ab17-82b51d4a565d)
```kotlin
navController.navigate(HomeScreen)
```
Mengarahkan pengguna ke layar HomeScreen.
```kotlin
popUpTo(navController.graph.startDestinationId):
```

Menghapus semua layar di atas layar awal (startDestination) dari tumpukan navigasi.

```kotlin
saveState = true
```
Menyimpan state layar yang dihapus, sehingga bisa dipulihkan jika kembali ke layar tersebut.

```kotlin
restoreState = true:
```
Mengembalikan state (misalnya scroll position atau input) layar HomeScreen jika sebelumnya sudah pernah dibuka.

## Bottom Navbar Visual
![image](https://github.com/user-attachments/assets/6f7a3a2c-5fa2-4e2b-baea-820002ddf919)

## RegisterScreen Navigation
![image](https://github.com/user-attachments/assets/be2477fd-9368-4c8f-93c2-5b2f12a0be07)

```kotlin
 onClick = {
     Toast.makeText(
        context,
        "Registration Successful!",
       Toast.LENGTH_SHORT
     ).show()
    navController.navigate(com.example.jetpckcompose.HomeScreen)
}
```
- **`Toast`**: Menampilkan pesan singkat **"Registrasi Berhasil!"** kepada pengguna sebagai notifikasi sementara.
- **`navController.navigate("home_screen")`**: Mengarahkan pengguna ke rute `home_screen` setelah pesan ditampilkan.
- **`LocalContext.current`**: Mendapatkan konteks aplikasi yang diperlukan untuk membuat `Toast`.

```kotlin
onClick = { navController.navigate(com.example.jetpckcompose.LoginScreen) }
```
- **`navController.navigate("home_screen")`**: Mengarahkan pengguna ke rute `LoginScreen`.

## RegisterScreen Navigation Visual
![image](https://github.com/user-attachments/assets/b06fa662-0a4d-4a51-89eb-9c9eb0774a8f)

## LoginScreen Navigation
![image](https://github.com/user-attachments/assets/3d6eee5d-9ee5-4a0a-8f9e-77de99c6cd0a)
```kotlin
onClick = {
    Toast.makeText(
        context,
        "Login button clicked",
        Toast.LENGTH_SHORT
    ).show()

    navController.navigate(com.example.jetpckcompose.HomeScreen)
}
```
1. **`Toast.makeText`**:
   - Menampilkan pesan singkat **"Login button clicked"** kepada pengguna.
   - Digunakan sebagai notifikasi sementara untuk memberi tahu bahwa tombol login telah ditekan.

2. **`navController.navigate(com.example.jetpckcompose.HomeScreen)`**:
   - Mengarahkan pengguna ke layar `HomeScreen`.

## LoginScreen Navigation Visual
![image](https://github.com/user-attachments/assets/6efb798b-b8ff-44b6-bba7-105eb30d6fec)

## HomeScreen Navigation
![image](https://github.com/user-attachments/assets/d533f42d-9d0f-4888-a3c8-49a2681e836f)
```kotlin
Button(
    modifier = Modifier.fillMaxWidth(),
    colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(R.color.greengacor),
        contentColor = Color.White
    ),
    onClick = {
        navController.navigateUp()
    }
) {
    Text("Logout")
}
```
1. **`onClick`**:
   - Ketika tombol ditekan, navigasi akan memanggil **`navController.navigateUp()`**, yang membawa pengguna kembali ke layar sebelumnya.

## HomeScreen Navigation Visual
![image](https://github.com/user-attachments/assets/a774f786-ece7-4d99-8ea4-a173c166709a)

## Profile Navigation
![image](https://github.com/user-attachments/assets/619a7d8a-03fe-456e-8163-1f4dbb57e64d)
```kotlin
Button(
    onClick = {
        navController.navigate(com.example.jetpckcompose.LoginScreen)
    },
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
    colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(R.color.greengacor),
        contentColor = Color.White
    ),
) {
    Text(
        text = "LOGOUT",
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}
```
1. **`onClick`**:
   - Ketika tombol ditekan, aplikasi akan **navigasi** ke layar login (`LoginScreen`).

## Profile Navigation Visual
![image](https://github.com/user-attachments/assets/b609490b-f4de-4026-891d-dd0c53da2e66)
