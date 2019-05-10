package apf.host;

import android.util.Pair;

import com.limpoxe.fairy.content.PluginDescriptor;
import com.limpoxe.fairy.manager.mapping.StubMappingProcessor;

public class StubVideoDetailProcessor implements StubMappingProcessor {

    private Pair<String, String> pair;

    @Override
    public int getType() {
        return TYPE_ACTIVITY;
    }

    @Override
    public String bindStub(PluginDescriptor pluginDescriptor, String pluginComponentClassName) {
        if (pluginComponentClassName.equals(
                "com.kuaiest.video.video.activity.VideoDetailActivity")) {//填写要绑定的插件中的组件名称
            String stub = "apf.host.stub.XXX"; //填写在宿主manifest增加的stub
            pair = new Pair<String, String>(stub, pluginComponentClassName);
            return pair.first;
        }
        return null;
    }

    @Override
    public void unBindStub(String stubClassName, String pluginStubClass) {
        if (pair != null && pair.first.equals(stubClassName) && pair.second.equals(pluginStubClass)) {
            pair = null;
        }
    }

    @Override
    public boolean isStub(String stubClassName) {
        String stub = "apf.host.stub.XXX"; //填写在宿主manifest增加的stub
        return stubClassName.equals(stub);
    }

    @Override
    public String getBindedPluginClassName(String stubClassName) {
        if (pair != null && pair.first.equals(stubClassName)) {
            return pair.second;
        }
        return null;
    }
}
