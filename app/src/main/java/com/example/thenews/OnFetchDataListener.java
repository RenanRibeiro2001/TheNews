package com.example.thenews;

import com.example.thenews.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse>{
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String messenge);
}
