package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.model.dto.PostDto.Transfer;
import com.example.springbootexersicemain.model.entity.Post;
import com.example.springbootexersicemain.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:34:55+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public List<Transfer> entityToDtoList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( posts.size() );
        for ( Post post : posts ) {
            list.add( entityToDtoTransfer( post ) );
        }

        return list;
    }

    @Override
    public Transfer entityToDtoTransfer(Post posts) {
        if ( posts == null ) {
            return null;
        }

        Transfer transfer = new Transfer();

        transfer.setUserId( postsUserId( posts ) );
        transfer.setId( posts.getId() );
        transfer.setTitle( posts.getTitle() );
        transfer.setBody( posts.getBody() );
        transfer.setSummary( posts.getSummary() );
        transfer.setSlug( posts.getSlug() );
        transfer.setVip( posts.getVip() );
        transfer.setCreateDate( posts.getCreateDate() );
        transfer.setUpdateDate( posts.getUpdateDate() );
        transfer.setPostType( posts.getPostType() );

        return transfer;
    }

    @Override
    public PostDto entityToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setId( post.getId() );
        postDto.setTitle( post.getTitle() );
        postDto.setBody( post.getBody() );
        postDto.setSummary( post.getSummary() );
        postDto.setSlug( post.getSlug() );
        postDto.setCreateDate( post.getCreateDate() );
        postDto.setUpdateDate( post.getUpdateDate() );
        postDto.setPostType( post.getPostType() );
        postDto.setVip( post.getVip() );

        return postDto;
    }

    private Long postsUserId(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
