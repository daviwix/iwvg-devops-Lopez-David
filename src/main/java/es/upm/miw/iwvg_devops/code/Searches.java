package es.upm.miw.iwvg_devops.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Searches {

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName){
        final Fraction[] result = {new Fraction()};
        new UsersDatabase().findAll()
                .filter(user -> familyName.equals(user.getFamilyName()))
                .map(User::getFractions)
                .reduce( (initialFractionList, otherFractionList) -> {
                    List<Fraction> newList= new ArrayList<>();
                    newList.addAll(initialFractionList);
                    newList.addAll(otherFractionList);
                    return newList;
                })
                .get()
                .forEach(fraction -> {
                    result[0] = result[0].multiply(fraction);
                });
        return result[0];
    }

    public Double findFirstDecimalFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .map(User::getFractions)
                .findFirst()
                .get()
                .get(0)
                .decimal();
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction(){
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal)
                .filter(result -> result < 0);
    }
}
