package squaring.vitrox.stylight.DependencyInjection.Component;

import dagger.Component;
import squaring.vitrox.stylight.DependencyInjection.ActivityScope;
import squaring.vitrox.stylight.MainActivity;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent{

    void inject(MainActivity activity);

}