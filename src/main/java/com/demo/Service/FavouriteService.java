package com.demo.Service;

import com.demo.Entity.Favourite;
import com.demo.Search.FavouriteDetail;
import com.demo.Entity.Key.FavouriteKey;
import com.demo.Repository.FavouriteRepository;
import com.demo.Search.SearchBooksDetailByUidAndTid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class FavouriteService {
    private  final FavouriteRepository repository;

    public Iterable<FavouriteDetail> findFavouritesByUid(Integer uid){
        return repository.findFavouritesByUid(uid);
    }

    public Iterable<Favourite> findFavouritesByISBN(String ISBN){
        return repository.findFavouritesByISBN(ISBN);
    }

    // 从Label获取所有标签tid，然后逐个使用tid，配合uid，获取所有书的详细信息
    public Iterable<SearchBooksDetailByUidAndTid> searchBooksDetailByUidAndTid(Integer uid, Integer tid){
        return repository.searchBooksDetailByUidAndTid(uid, tid);
    }

    public Optional<Favourite> findFavourite(Favourite favourite){
        return repository.findById(new FavouriteKey(favourite.getUid(), favourite.getISBN()));
    }

    public Optional<Favourite> searchFavourite(Integer uid, String ISBN){
        return repository.findById(new FavouriteKey(uid, ISBN));
    }

    public boolean update(Favourite favourite){
        if(repository.existsById(new FavouriteKey(favourite.getUid(), favourite.getISBN()))){

            repository.save(favourite);
            return true;
        }
        return false;
    }

    public boolean exists(Favourite favourite){
        return repository.existsById(new FavouriteKey(favourite.getUid(), favourite.getISBN()));
    }

    public boolean existsByUidAndISBN(Integer uid, String ISBN){
        return repository.existsById(new FavouriteKey(uid, ISBN));
    }

    public boolean insert(Favourite favourite){
        repository.save(favourite);
        return true;
    }

    public boolean deleteByUidAndISBN(Integer uid, String ISBN){
        repository.deleteById(new FavouriteKey(uid, ISBN));
        return true;
    }
}
