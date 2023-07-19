package tien.baseproject.userservice.mapper;


public interface Mapper<T, S, V> {
     T toDto(S entity);

     S toEntity(V request);
}
