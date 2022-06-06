package com.demo.Repository;

import com.demo.Entity.Favourite;
import com.demo.Search.FavouriteDetail;
import com.demo.Entity.Key.FavouriteKey;
import com.demo.Search.SearchBooksDetailByUidAndTid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, FavouriteKey> {
    @Query(value = "select new com.demo.Search.FavouriteDetail(f.uid,f.ISBN,f.time,f.tid,l.content,f.progress,b.bookName,b.author,b.publisher,b.pageCount,b.icon) " +
            "from Favourite f inner join Book b on f.ISBN=b.ISBN inner join Label l on f.tid=l.tid where f.uid=?1")
    Iterable<FavouriteDetail> findFavouritesByUid(Integer uid);

    @Query(value = "select new com.demo.Search.SearchBooksDetailByUidAndTid(f.uid,f.tid,l.content,b.ISBN,b.bookName,b.author,b.publisher,b.pageCount,b.icon) " +
            "from Favourite f inner join Label l on f.tid=l.tid inner join Book b on f.ISBN=b.ISBN where f.uid=?1 and f.tid=?2")
    Iterable<SearchBooksDetailByUidAndTid> searchBooksDetailByUidAndTid(Integer uid, Integer tid);

    Iterable<Favourite> findFavouritesByISBN(String ISBN);
}
