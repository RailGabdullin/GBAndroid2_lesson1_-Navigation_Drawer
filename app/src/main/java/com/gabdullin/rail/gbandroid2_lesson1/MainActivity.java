package com.gabdullin.rail.gbandroid2_lesson1;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        Структура ресурсов Navigation menu

        --activity_main
            --Лайаут с осн.контентом app_bar_main
                --Верхний тулбар
                --Фрагмент с ссылкой на список фрагментов для пунктов меню nav_host_fragment
                    --Список фрагментов для пунктов меню mobile_navigation
                        --Отдельные фрагменты для пунктов меню, например fragment_home
                            --Контент фрагмента связан с классом в ../java/../ui/[название пунтка меню]/..
                --Плавающая кнопка
            --Вью для меню NavigationView
                --Хедер nav_header_main
                --Список пунктов меню activity_main_drawer
         */


        //Это верхний тулбар. Лежит в app_bar_main
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Это плавающая кнопка
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //Это главный лейаут менеджер в activity_main.
        //Особенный. Нужен будет чтобы собрать в него пункты меню из activity_main_drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        //Это сама выдвигающаяся панелька меню. Лежит в activity_main.
        NavigationView navigationView = findViewById(R.id.nav_view);



        //Собираем все пункты меню из ресурса activity_main_drawer в один контрллер

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();

        //Это фрагмент с фрагментами всех пунктов меню.
        //Он лежит в лейауте с основным контентом content_mine
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        //В специальном классе для навигационного меню вызываем метод, в котором соединяем
        //фрагменты и пункты меню
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //К фрагментам из *nav_host_fragment* и пунктам из *activity_main_drawer* добавляем контроллер из *activity_main*
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
