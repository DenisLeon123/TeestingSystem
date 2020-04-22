package all.factoryTesterService;

import all.tester.FactoryTester;

public class FactoryTesterService {
    private FactoryTester factoryTester;

    public FactoryTesterService(FactoryTester factoryTester){
        this.factoryTester =factoryTester;
    }

    public FactoryTester getFactoryTester(String patchTest){
        return factoryTester.createFactoryTester(patchTest);
    }

}
