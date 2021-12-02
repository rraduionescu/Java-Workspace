package com.ase.ionescuradu.carexpress.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.ase.ionescuradu.carexpress.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

//  Created by IonescuRadu on 28/05/2018.  //

public class DatabaseTask extends AsyncTask<String, Integer, String>
{
    @SuppressLint("StaticFieldLeak")
    private final Context context;
    private final Intent intent;

    public DatabaseTask(Context context, Intent intent)
    {
        this.context = context;
        this.intent = intent;
    }

    @Override
    protected String doInBackground(String... args)
    {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        HttpURLConnection connection = null;
        URL url;

        switch (args[0])
        {
            case "select_address":
            {
                StringBuffer response = null;
                try
                {
                    assert user != null;
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_address&id_client=" + user.getUid());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "insert_client":
            {
                assert user != null;
                String name[] = Objects.requireNonNull(user.getDisplayName()).split(" ");
                try
                {
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=insert_client&id_client=" + user.getUid() + "&first_name=" + name[0] + "&last_name=" + name[1]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.getResponseCode();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                return null;
            }
            case "insert_address":
            {
                assert user != null;
                try
                {
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=insert_address&id_client=" + user.getUid() + "&address=" + args[1]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.getResponseCode();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                return null;
            }
            case "insert_option_row":
            {
                try
                {
                    JSONArray options = new JSONArray(Objects.requireNonNull(intent.getExtras()).getString("option_json"));
                    for (int i = 0; i < options.length(); i++)
                    {
                        String name = options.getJSONObject(i).getString("name");
                        String id_rental = args[1];
                        String id_vehicle = new JSONObject(intent.getExtras().getString("vehicle_json")).get("id_vehicle").toString();
                        String id_client = Objects.requireNonNull(user).getUid();
                        String id_centre = new JSONObject(intent.getExtras().getString("vehicle_json")).get("id_centre").toString();
                        url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=insert_option_row&name=" + name + "&id_rental=" + id_rental + "&id_vehicle=" + id_vehicle + "&id_client=" + id_client + "&id_centre=" + id_centre);
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.getResponseCode();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }

                return null;
            }
            case "insert_rental":
            {
                StringBuffer response = null;
                try
                {
                    String start_date = Objects.requireNonNull(intent.getExtras()).getString("start_date");
                    String end_date = intent.getExtras().getString("end_date");
                    String id_vehicle = new JSONObject(intent.getExtras().getString("vehicle_json")).get("id_vehicle").toString();
                    String id_client = Objects.requireNonNull(user).getUid();
                    String id_centre = new JSONObject(intent.getExtras().getString("vehicle_json")).get("id_centre").toString();
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=insert_rental&start_date=" + start_date + "&end_date=" + end_date + "&id_vehicle=" + id_vehicle + "&id_client=" + id_client + "&id_centre=" + id_centre);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "select_option":
            {
                StringBuffer response = null;
                try
                {
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_option");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "select_rental":
            {
                StringBuffer response = null;
                try
                {
                    response = new StringBuffer();
                    assert user != null;
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_rental&id_client=" + user.getUid());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "select_rental_vehicle":
            {
                StringBuffer response = null;
                try
                {
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_rental_vehicle&id_vehicle=" + args[1]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "select_rental_option":
            {
                StringBuffer response = null;
                try
                {
                    String id_rental = args[1];
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_rental_option&id_rental=" + id_rental);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
            case "select_vehicle":
            {
                String category = Objects.requireNonNull(intent.getExtras()).getString("category");
                String sDate = intent.getExtras().getString("start_date");
                String eDate = intent.getExtras().getString("end_date");
                connection = null;
                StringBuffer response = null;
                try
                {
                    response = new StringBuffer();
                    url = new URL("http://" + context.getResources().getString(R.string.ip) + ":8080/Database?option=select_vehicle&category=" + category + "&s_date=" + sDate + "&e_date=" + eDate);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    connection.getResponseCode();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (connection != null)
                    {
                        connection.disconnect();
                    }
                }
                assert response != null;
                return response.toString();
            }
        }
        return null;
    }
}