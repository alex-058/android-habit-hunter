package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new org.othr.habithunter.DataBinderMapperImpl());
  }
}
