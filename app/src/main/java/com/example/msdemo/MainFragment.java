package com.example.msdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msdemo.bean.Person;
import com.example.msdemo.recycleview.CustomItemDecoration;
import com.example.msdemo.recycleview.MainAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


public class MainFragment extends Fragment  {
    public static final String INFO="[\n" +
            "  {\n" +
            "    \"first_name\": \"Allan\",\n" +
            "    \"last_name\": \"Munger\",\n" +
            "    \"avatar_filename\": \"Allan Munger.png\",\n" +
            "    \"title\": \"Writer\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Amanda\",\n" +
            "    \"last_name\": \"Brady\",\n" +
            "    \"avatar_filename\": \"Amanda Brady.png\",\n" +
            "    \"title\": \"Sales Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Ashley\",\n" +
            "    \"last_name\": \"Mc Carthy\",\n" +
            "    \"avatar_filename\": \"Ashley Mc Carthy.png\",\n" +
            "    \"title\": \"Sales Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Carlos\",\n" +
            "    \"last_name\": \"Slattery\",\n" +
            "    \"avatar_filename\": \"Carlos Slattery.png\",\n" +
            "    \"title\": \"Nurse\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Carole\",\n" +
            "    \"last_name\": \"Poland\",\n" +
            "    \"avatar_filename\": \"Carole Poland.png\",\n" +
            "    \"title\": \"Internet/Social Media Evaluator\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Cecil\",\n" +
            "    \"last_name\": \"Folk\",\n" +
            "    \"avatar_filename\": \"Cecil Folk.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Celeste\",\n" +
            "    \"last_name\": \"Burton\",\n" +
            "    \"avatar_filename\": \"Celeste Burton.png\",\n" +
            "    \"title\": \"Case Manager\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Charlotte\",\n" +
            "    \"last_name\": \"Waltson\",\n" +
            "    \"avatar_filename\": \"Charlotte Waltson.png\",\n" +
            "    \"title\": \"Editor\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Colin\",\n" +
            "    \"last_name\": \"Ballinger\",\n" +
            "    \"avatar_filename\": \"Colin Ballinger.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Daisy\",\n" +
            "    \"last_name\": \"Phillips\",\n" +
            "    \"avatar_filename\": \"daisy_phillips.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Elliot\",\n" +
            "    \"last_name\": \"Woodward\",\n" +
            "    \"avatar_filename\": \"Elliot Woodward.png\",\n" +
            "    \"title\": \"Project Manager\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Elvia\",\n" +
            "    \"last_name\": \"Atkins\",\n" +
            "    \"avatar_filename\": \"Elvia Atkins.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Erik\",\n" +
            "    \"last_name\": \"Nason\",\n" +
            "    \"avatar_filename\": \"Erik Nason.png\",\n" +
            "    \"title\": \"Consultant\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Henry\",\n" +
            "    \"last_name\": \"Brill\",\n" +
            "    \"avatar_filename\": \"Henry Brill.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Praesent pellentesque, sapien ut lobortis lacinia, erat magna venenatis turpis, eu maximus magna lectus a sapien. Aenean luctus tellus vel dui euismod bibendum. Aenean at elementum neque. Integer non aliquam risus. Ut porta, lectus et finibus sodales, mi nulla hendrerit dui, finibus consectetur arcu ligula ac velit. Suspendisse eu mollis diam. Vestibulum porta, elit a dignissim mollis, dolor risus sagittis sapien, quis tristique nunc massa interdum ligula. Duis a turpis nulla. Vivamus a consequat justo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Isaac\",\n" +
            "    \"last_name\": \"Fielder\",\n" +
            "    \"avatar_filename\": \"Isaac Fielder.png\",\n" +
            "    \"title\": \"Teacher\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Johnie\",\n" +
            "    \"last_name\": \"McConnell\",\n" +
            "    \"avatar_filename\": \"Johnie McConnell.png\",\n" +
            "    \"title\": \"Tutor\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kat\",\n" +
            "    \"last_name\": \"larsson\",\n" +
            "    \"avatar_filename\": \"Kat larsson.png\",\n" +
            "    \"title\": \"Engineer\",\n" +
            "    \"introduction\": \"Ut malesuada sollicitudin tincidunt. Maecenas volutpat suscipit efficitur. Curabitur ut tortor sit amet lacus pellentesque convallis in laoreet lectus. Curabitur lorem velit, bibendum et vulputate vulputate, commodo in tortor. Curabitur a dapibus mauris. Vestibulum hendrerit euismod felis at hendrerit. Pellentesque imperdiet volutpat molestie. Nam vehicula dui eu consequat finibus. Phasellus sed placerat lorem. Nulla pretium a magna sit amet iaculis. Aenean eget eleifend elit. Ut eleifend aliquet interdum. Cras pulvinar elit a dapibus iaculis. Nullam fermentum porttitor ultrices.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Katri\",\n" +
            "    \"last_name\": \"Ahokas\",\n" +
            "    \"avatar_filename\": \"Katri Ahokas.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kevin\",\n" +
            "    \"last_name\": \"Sturgis\",\n" +
            "    \"avatar_filename\": \"Kevin Sturgis.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Kristin\",\n" +
            "    \"last_name\": \"Patterson\",\n" +
            "    \"avatar_filename\": \"Kristin Patterson.png\",\n" +
            "    \"title\": \"Writer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Lydia\",\n" +
            "    \"last_name\": \"Bauer\",\n" +
            "    \"avatar_filename\": \"Lydia Bauer.png\",\n" +
            "    \"title\": \"Analyst\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Mauricio\",\n" +
            "    \"last_name\": \"August\",\n" +
            "    \"avatar_filename\": \"Mauricio August.png\",\n" +
            "    \"title\": \"Analyst\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Miguel\",\n" +
            "    \"last_name\": \"Garcia\",\n" +
            "    \"avatar_filename\": \"Miguel Garcia.png\",\n" +
            "    \"title\": \"Account Manager\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Mona\",\n" +
            "    \"last_name\": \"Kane\",\n" +
            "    \"avatar_filename\": \"Mona Kane.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Robert\",\n" +
            "    \"last_name\": \"Tolbert\",\n" +
            "    \"avatar_filename\": \"Robert Tolbert.png\",\n" +
            "    \"title\": \"Territory Sales Manager\",\n" +
            "    \"introduction\": \"Phasellus eget pellentesque augue. Morbi quis est non urna posuere efficitur vitae ut erat. Nam aliquam ex a lacus fermentum mattis. Suspendisse a ligula rhoncus, pulvinar turpis a, sagittis elit. Morbi placerat urna accumsan, egestas turpis quis, commodo lorem. Nam convallis fermentum neque eu varius. Nullam sed gravida elit, at tincidunt est. Praesent arcu velit, vehicula rutrum leo ac, efficitur vestibulum lacus. Aliquam rutrum efficitur nulla, sed sollicitudin tellus suscipit ut. Vestibulum porta turpis vel purus vestibulum, ac euismod erat commodo. Nulla luctus ultricies blandit. Nunc faucibus, purus sit amet scelerisque tincidunt, augue elit posuere justo, id tristique sem elit nec nunc. Fusce congue dui vel sem aliquet volutpat. Nullam eget tincidunt nulla. Aenean interdum, turpis nec accumsan sollicitudin, risus mi pellentesque eros, nec iaculis lectus ligula ut tellus. Phasellus at aliquet nisl, at aliquam nulla.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Robin\",\n" +
            "    \"last_name\": \"Counts\",\n" +
            "    \"avatar_filename\": \"Robin Counts.png\",\n" +
            "    \"title\": \"Customer Service Representative\",\n" +
            "    \"introduction\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar neque in ullamcorper finibus. Aliquam ante orci, elementum non efficitur id, commodo ac velit. Proin non ornare neque, ac ornare odio. Nullam imperdiet tellus lacinia, semper justo vel, elementum metus. Aenean eget diam at quam dignissim varius. Nunc sed urna vehicula ipsum efficitur volutpat. Mauris vel augue ut magna tincidunt imperdiet. Integer sit amet vestibulum justo. Aenean placerat, nibh ac accumsan tincidunt, lorem arcu maximus justo, sed elementum tellus nisi id purus. Sed ac porttitor orci. Etiam et augue ullamcorper nibh mattis pharetra. Suspendisse ac mauris nec velit euismod rhoncus. Vestibulum tempor magna purus, id lacinia erat tempus eget.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Tim\",\n" +
            "    \"last_name\": \"Deboer\",\n" +
            "    \"avatar_filename\": \"Tim Deboer.png\",\n" +
            "    \"title\": \"Developer\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"first_name\": \"Wanda\",\n" +
            "    \"last_name\": \"Howard\",\n" +
            "    \"avatar_filename\": \"Wanda Howard.png\",\n" +
            "    \"title\": \"Accountant\",\n" +
            "    \"introduction\": \"Suspendisse venenatis eros et leo dignissim faucibus. Nullam egestas purus non scelerisque gravida. Sed ultricies gravida metus, eu rhoncus neque. Donec varius sem et metus luctus, eget maximus felis imperdiet. Aliquam id eros ipsum. Sed magna ligula, faucibus tristique ornare a, sagittis non ex. Aenean facilisis, mi at interdum lobortis, lectus eros fermentum magna, finibus porta lacus ipsum ut ipsum. Sed placerat nisl vel arcu finibus elementum. Fusce porta fringilla velit, quis aliquam leo porta consequat. Cras lobortis sapien id lectus sollicitudin elementum. Sed arcu leo, euismod in nulla eu, eleifend fermentum sapien.\"\n" +
            "  }\n" +
            "]";
    private MainActivity mMainActivity;
    private RecyclerView bannerReycleView;
    private RecyclerView detailReycleView;
    /**
     * Generate by live templates.
     * Use FragmentManager to find this Fragment's instance by tag
     */
    public static MainFragment getFragment(FragmentManager manager) {
        MainFragment fragment=(MainFragment) manager.findFragmentByTag(MainFragment.class.getSimpleName());
        if(fragment==null){
            fragment=newInstance();
        }
        return fragment;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bannerReycleView=view.findViewById(R.id.banner);
        detailReycleView=view.findViewById(R.id.detail);
        initView(view,savedInstanceState);
    }

    protected void initView(View root, Bundle savedInstanceState) {
        final List<Person> title = fillData();

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        MainAdapter horizontalAdapter = new MainAdapter(title,getActivity().getApplicationContext());
        bannerReycleView.setLayoutManager(horizontalLayoutManager);
        bannerReycleView.setAdapter(horizontalAdapter);
        new LinearSnapHelper().attachToRecyclerView(bannerReycleView);
        bannerReycleView.addItemDecoration(new CustomItemDecoration());



        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext());
        MainAdapter verticalAdapter = new MainAdapter(title, MainAdapter.VIEW_TYPE_TEXT,getActivity().getApplicationContext());
        detailReycleView.setLayoutManager(verticalLayoutManager);
        detailReycleView.setAdapter(verticalAdapter);
        new PagerSnapHelper().attachToRecyclerView(detailReycleView);
        detailReycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    int firstItemPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
                    bannerReycleView.scrollToPosition(firstItemPosition);
                }
            }
        });

        bannerReycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    int firstItemPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
                    detailReycleView.scrollToPosition(firstItemPosition);
                }
            }
        });
        horizontalAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                detailReycleView.scrollToPosition(position);
            }
        });
    }

    private List<Person> fillData() {
        String gsonString=INFO;
        Person[] personArray=gson.fromJson(gsonString,Person[].class);
        return Arrays.asList(personArray);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private static Gson gson=new Gson();
}
